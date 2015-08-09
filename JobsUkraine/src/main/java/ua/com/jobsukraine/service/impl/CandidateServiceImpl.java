package ua.com.jobsukraine.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Feedback;
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

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private LoginInfoRepository loginInfoRepository;
     
	@Override
	public Candidate register(Candidate candidate, LoginInfo info) {
		info.setRole(roleService.findByName("ROLE_EMPLOYER"));
		List<Category> listcat = new ArrayList<>();
		for (Category category : candidate.getCategories()) {
			Category cat = categoryRepository.findByName(category.getName());
			listcat.add(cat);
		}
		candidate.setCategories(listcat);
		candidate.setInfo(info);
		return 	candidateRepository.save(candidate);
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
		Candidate c = null;
		try {
			c = candidateRepository.findOne(id);
			if (candidateRepository.getFeedbacks(id).size() > 0)
				c.setRating(candidateRepository.getGlobalRating(id));
		} catch (EmptyResultDataAccessException e) {
		}
		return c;
	}

	@Override
	public Candidate findByLogin(String login) {
		Candidate c = null;
		try {
			c = candidateRepository.findByInfo(loginInfoRepository.findByLogin(login));
			if (candidateRepository.getFeedbacks(c.getId()) != null)
				c.setRating(candidateRepository.getGlobalRating(c.getId()));
		} catch (EmptyResultDataAccessException e) {
		}
		return c;
	}

	@Override
	public List<Vacancy> getAvailableVacancies(String login) {
		List<Vacancy> vacancies = null;
		try {
			vacancies = candidateRepository.getAvailableVacancies(candidateRepository.findByInfo(loginInfoRepository.findByLogin(login)).getId());
		} catch (EmptyResultDataAccessException e) {
		}
		return vacancies;
	}

	@Override
	public int getAge(String login) {
		Candidate c = null;
		int age = 0;
		try {
			
			c = candidateRepository.findByInfo(loginInfoRepository.findByLogin(login));
			Calendar cal = new GregorianCalendar();
			cal.setTime(c.getDateOfBirth());
			Calendar now = new GregorianCalendar();
			age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
			if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
					|| (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH)
							&& cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
				age--;
			}
		} catch (EmptyResultDataAccessException e) {
		}
		return age;
	}

	public List<Feedback> getFeedbacks(int id){
		return candidateRepository.getFeedbacks(id);
	}
	
	@Override
	public Candidate add(Candidate candidate) {
		
		return candidateRepository.save(candidate);

	}
	
	
}
