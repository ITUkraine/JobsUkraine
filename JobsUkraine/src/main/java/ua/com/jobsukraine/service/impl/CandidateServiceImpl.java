package ua.com.jobsukraine.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.CandidateRepository;
import ua.com.jobsukraine.repository.CategoryRepository;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.RoleService;

@Service
@ComponentScan(basePackages ="ua.com.jobsukraine.security")
@Transactional
public class CandidateServiceImpl implements CandidateService {

	private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private LoginInfoRepository loginInfoRepository;
	@Autowired
	private RoleService roleService;
     
	@Override
	public Candidate add(Candidate candidate) {	
		return candidateRepository.save(candidate);
	}

	@Override
	public void delete(int id) {
		candidateRepository.delete(id);
	}

	@Override
	public Candidate edit(Candidate candidate) {
		return candidateRepository.saveAndFlush(candidate);
	}

	@Override
	public Candidate find(int id) {
		Candidate candidate = null;
		try {
			candidate = candidateRepository.findOne(id);
			if (candidate.getFeedbacks().size() > 0) {
				candidate.setRating(candidateRepository.getGlobalRating(candidate));
			}
		} catch (EmptyResultDataAccessException e) {
		}
		return candidate;
	}

	@Override
	public Candidate findByLogin(String login) {
		Candidate candidate = null;
		try {
			candidate = candidateRepository.findByLoginInfo(loginInfoRepository.findByLogin(login));
			if (candidate.getFeedbacks().size() > 0) {
				candidate.setRating(candidateRepository.getGlobalRating(candidate));
			}
		} catch (EmptyResultDataAccessException e) {
		}
		return candidate;
	}

	@Override
	public int getAge(Candidate candidate) {
		int age = 0;
		try {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(candidate.getDateOfBirth());
			Calendar now = new GregorianCalendar();
			age = now.get(Calendar.YEAR) - calendar.get(Calendar.YEAR);
			if ((calendar.get(Calendar.MONTH) > now.get(Calendar.MONTH))
					|| (calendar.get(Calendar.MONTH) == now.get(Calendar.MONTH)
							&& calendar.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		} catch (EmptyResultDataAccessException e) {
		}
		return age;
	}

	@Override
	public List<Vacancy> getAvailableVacancies(Candidate candidate) {
		List<Vacancy> vacancies = null;
		try {
			vacancies = candidateRepository.getAvailableVacancies(candidate);
		} catch (EmptyResultDataAccessException e) {
			logger.error("Candidate doesn't have available vacancies", e);
		}
		return vacancies;
	}

	@Override
	public Candidate register(Candidate candidate, LoginInfo info) {
		info.setRole(roleService.findByName("ROLE_CANDIDATE"));
		List<Category> listcat = new ArrayList<>();
		for (Category category : candidate.getCategories()) {
			Category cat = categoryRepository.findByName(category.getName());
			listcat.add(cat);
		}
		candidate.setCategories(listcat);
		candidate.setInfo(info);
		return candidateRepository.save(candidate);
	}
	
	
}
