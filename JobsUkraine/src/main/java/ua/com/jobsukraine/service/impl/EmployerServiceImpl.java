package ua.com.jobsukraine.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
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
	private EmployerRepository employerRepository;
	@Autowired
	private RoleService roleRepository;
	@Autowired
	private LoginInfoRepository loginInfoRepository;
	@Autowired
	private CategoryService categoryService;

	@Override
	public Employer register(Employer emp, LoginInfo info) {
		info.setRole(roleRepository.findByName("ROLE_EMPLOYER"));
		List<Category> listcat = new ArrayList<>();
		for (Category category : emp.getCategories()) {
			Category cat = categoryService.findByName(category.getName());
			listcat.add(cat);
		}
		emp.setCategories(listcat);
		emp.setInfo(info);
		return employerRepository.save(emp);

	}

	@Override
	public void delete(int id) {
		employerRepository.delete(id);
	}

	@Override
	public Employer edit(Employer employer) {
		return employerRepository.saveAndFlush(employer);
	}

	@Override
	public Employer find(int id) {
		return employerRepository.findOne(id);
	}

	@Override
	public Employer findByLogin(String login) {
		return employerRepository.findByInfo(loginInfoRepository.findByLogin(login));
	}

	@Override
	public List<Candidate> getAvailableCandidates(List<Category> categories, int top) {
		List<Candidate> allCandidates = new ArrayList<>();
		for (Category ctgr : categories) {
			// get candidate+his rating->set rating->add to list as one object
			for (Object o[] : employerRepository.getAvailableCandidates(ctgr.name)) {
				((Candidate) o[0]).setRating((Double) o[1]);
				allCandidates.add((Candidate) o[0]);
			}
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

		if (allCandidates.size() > top)
			return allCandidates.subList(0, top);
		else
			return allCandidates;
	}

	public List<Vacancy> getVacancies(String login) {
		return employerRepository
				.getVacancies(employerRepository.findByInfo(loginInfoRepository.findByLogin(login)).getId());

	}
	@Override
	public Employer add(Employer employer) {
		return employerRepository.saveAndFlush(employer);

	}
	

}
