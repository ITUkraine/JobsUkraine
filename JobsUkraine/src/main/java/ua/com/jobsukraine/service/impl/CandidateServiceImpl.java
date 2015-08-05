package ua.com.jobsukraine.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
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


	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	private CandidateRepository cr;
	@Autowired
	private LoginInfoRepository lis;
	@Autowired
	private RoleService rs;
	@Autowired
	private CategoryRepository catServ;
	

	@Override
	public Candidate add(Candidate candidate) {
		String hashPassword = encoder.encode(candidate.getInfo().getPassword());
		candidate.getInfo().setPassword(hashPassword);
		candidate.getInfo().setConfirmPassword(hashPassword);
		candidate.getInfo().setRole(rs.findByName("ROLE_CANDIDATE"));
		lis.save(candidate.getInfo());
		cr.save(candidate);
		// TODO
		for (Category category : candidate.getCategories()) {
			Category cat = catServ.findByName(category.getName());
			cat.getCandidates().add(candidate);
			/*
			 * List<Candidate> candidates = cat.getCandidates();
			 * candidates.add(candidate);
			 */
			//
			catServ.saveAndFlush(cat);
		}

		return candidate;

	}

	@Override
	public void delete(int id) {
		cr.delete(id);
	}

	@Override
	public Candidate edit(Candidate candidate) {
		return cr.saveAndFlush(candidate);
	}

	@Override
	public Candidate find(int id) {
		Candidate c = null;
		try {
			c = cr.findOne(id);
			if (cr.getFeedbacks(id).size() > 0)
				c.setRating(cr.getGlobalRating(id));
		} catch (EmptyResultDataAccessException e) {
		}
		return c;
	}

	@Override
	public Candidate findByLogin(String login) {
		Candidate c = null;
		try {
			c = cr.findByInfo(lis.findByLogin(login));
			if (cr.getFeedbacks(c.getId()).size() > 0)
				c.setRating(cr.getGlobalRating(c.getId()));
		} catch (EmptyResultDataAccessException e) {
		}
		return c;
	}

	@Override
	public List<Vacancy> getAvailableVacancies(String login) {
		List<Vacancy> vacancies = null;
		try {
			vacancies = cr.getAvailableVacancies(cr.findByInfo(lis.findByLogin(login)).getId());
		} catch (EmptyResultDataAccessException e) {
		}
		return vacancies;
	}

	@Override
	public int getAge(String login) {
		Candidate c = null;
		int age = 0;
		try {
			c = cr.findByInfo(lis.findByLogin(login));
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

}
