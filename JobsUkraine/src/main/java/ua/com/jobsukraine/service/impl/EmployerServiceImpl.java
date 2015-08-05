package ua.com.jobsukraine.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
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
	private EmployerRepository er;
	@Autowired
	private RoleService roleRep;
	@Autowired
	private LoginInfoRepository LoginInfoRep;
	@Autowired
	private CategoryService catServ;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Override
	public Employer add(Employer employer) {
		String hashPassword = encoder.encode(employer.getInfo().getPassword());
		employer.getInfo().setPassword(hashPassword);
		employer.getInfo().setConfirmPassword(hashPassword);
		employer.getInfo().setRole(roleRep.findByName("ROLE_EMPLOYER"));
		LoginInfoRep.saveAndFlush(employer.getInfo());
		er.saveAndFlush(employer);

		for (Category category : employer.getCategories()) {
			Category cat = catServ.findByName(category.getName());
			cat.getEmployers().add(employer);
			catServ.edit(cat);
		}

		return employer;

	}

	@Override
	public void delete(int id) {
		er.delete(id);
	}

	@Override
	public Employer edit(Employer employer) {
		return er.saveAndFlush(employer);
	}

	@Override
	public Employer find(int id) {
		return er.findOne(id);
	}

	@Override
	public Employer findByLogin(String login) {
		return er.findByLogin(login);
	}

	@Override
	public List<Candidate> getAvailableCandidates(List<Category> categories, int top) {
		List<Candidate> allCandidates = new ArrayList<>();
		for (Category ctgr : categories) {
			allCandidates.addAll(er.getAvailableCandidates(ctgr.name, top));
		}
		
		// remove duplicates by id
		Map<Integer, Candidate> map = new LinkedHashMap<>();
		for (Candidate ays : allCandidates) {
		  map.put(ays.getId(), ays);
		}
		allCandidates.clear();
		allCandidates.addAll(map.values());
		
		// sort by rating
		Collections.sort(allCandidates);
		
		return allCandidates;
	}

}
