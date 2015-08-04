package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@Transactional
public class CandidateServiceImpl implements CandidateService {

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
		candidate.getInfo().setRole(rs.findByName("ROLE_CANDIDATE"));
		lis.save(candidate.getInfo());
		cr.save(candidate);
//TODO
		for (Category category : candidate.getCategories()) {
		Category cat = catServ.findByName(category.getName());
		cat.getCandidates().add(candidate);
			/*List<Candidate> candidates = cat.getCandidates();
			candidates.add(candidate);*/
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
