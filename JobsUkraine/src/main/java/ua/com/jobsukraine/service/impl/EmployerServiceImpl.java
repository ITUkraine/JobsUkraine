package ua.com.jobsukraine.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.repository.EmployerRepository;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.RoleService;

@Service
@ComponentScan(basePackages = "ua.com.jobsukraine.security")
@Transactional
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EmployerRepository employerRepository;
	@Autowired
	private LoginInfoRepository loginInfoRepository;
	@Autowired
	private RoleService roleRepository;

	@Override
	public Employer save(Employer employer) {
		return employerRepository.saveAndFlush(employer);
	}

	@Override
	public Employer find(int id) {
		return employerRepository.findOne(id);
	}

	@Override
	public Employer findByLogin(String login) {
		return employerRepository.findByLoginInfo(loginInfoRepository.findByLogin(login));
	}

	@Override
	public Employer findByEmail(String email) {
		return employerRepository.findByEmail(email);
	}

	@Override
	public Set<Candidate> getAvailableCandidates(Employer employer, int top) {
		Set<Candidate> sortedCandidates = new TreeSet<>();
		for (Category category : employer.getCategories()) {
			// get candidate+his rating->set rating->add to set as one object
			for (Object o[] : employerRepository.getAvailableCandidates(category)) {
				((Candidate) o[0]).setRating((Double) o[1]);
				sortedCandidates.add((Candidate) o[0]);
			}
		}
		return sortedCandidates;
	}

	@Override
	public Employer register(Employer employer, LoginInfo info) {
		info.setRole(roleRepository.findByName("ROLE_EMPLOYER"));
		List<Category> listcat = new ArrayList<>();
		for (Category category : employer.getCategories()) {
			Category cat = categoryService.findByName(category.getName());
			listcat.add(cat);
		}
		employer.setCategories(listcat);
		employer.setInfo(info);
		if(employer.getPictureURL().equals(""))
			employer.setPictureURL("https://cdn3.iconfinder.com/data/icons/business-office-2/512/businessman_tie-512.png");
		return employerRepository.save(employer);

	}

	@Override
	public List<Employer> getAll() {
		return employerRepository.findAll();
	}

	@Override
	public void connectWithCandidate(Candidate candidate, Employer employer) {
		if (!employer.getCandidates().contains(candidate)) {
			employer.getCandidates().add(candidate);
			save(employer);
		}
	}

}
