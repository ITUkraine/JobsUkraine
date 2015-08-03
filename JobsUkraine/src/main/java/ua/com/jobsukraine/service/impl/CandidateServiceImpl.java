package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.CandidateRepository;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository cr;
	@Autowired
	private LoginInfoService lis;
	@Autowired
	private RoleService rs;
	@Autowired
	private CategoryService catServ;

	@Override
	public Candidate add(Candidate candidate) {
		candidate.getInfo().setRole(rs.findByName("candidate"));
		lis.add(candidate.getInfo());
		cr.saveAndFlush(candidate);
		List<Category> list = candidate.getCategories();

		for (Category category : list) {
			category.setCandidatInCategory(candidate);
			catServ.edit(category);
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
		Candidate c = cr.findOne(id);
		c.setRating(cr.getRating(id));
		return c;
	}

	@Override
	public Candidate findByName(String name) {
		Candidate c = cr.findByName(name);
		c.setRating(cr.getRating(c.getId()));
		return c;
	}

	@Override
	public Candidate findByLogin(String login) {
		Candidate c = cr.findByLogin(login);
		c.setRating(cr.getRating(c.getId()));
		return c;
	}

	@Override
	public List<Vacancy> getAvailableVacancies(String login) {
		return cr.getAvailableVacancies(login);
	}

}
