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
	public List<Candidate> getAll() {
		return cr.findAll();
	}

	@Override
	public Candidate find(int id) {
		return cr.findOne(id);
	}

	@Override
	public Candidate findByName(String name) {
		return findByName(name);
	}

	@Override
	public Candidate findByLogin(String login) {
		return cr.findByLogin(login);
	}

	@Override
	public List<Vacancy> getAvailableVacancies(String login) {
		return cr.getAvailableVacancies(login);
	}

	
}
