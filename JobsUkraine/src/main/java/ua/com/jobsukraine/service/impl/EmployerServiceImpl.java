package ua.com.jobsukraine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.repository.EmployerRepository;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.RoleService;

@Service
@Transactional
public class EmployerServiceImpl implements EmployerService {

	@Autowired
	private EmployerRepository ep;
	@Autowired
	private RoleService roleRep;
	@Autowired
	private LoginInfoRepository LoginInfoRep;
	@Autowired
	private CategoryService catServ;

	@Override
	public Employer add(Employer employer) {

		employer.getInfo().setRole(roleRep.findByName("employer"));
		LoginInfoRep.saveAndFlush(employer.getInfo());
		ep.saveAndFlush(employer);
		
		for (Category category : employer.getCategories()) {
			Category cat = catServ.findByName(category.getName());
			cat.getEmployers().add(employer);
			catServ.edit(cat);
		}

		return employer;

	}

	@Override
	public void delete(int id) {
		ep.delete(id);
	}

	@Override
	public Employer edit(Employer employer) {
		return ep.saveAndFlush(employer);
	}

	@Override
	public Employer find(int id) {
		return ep.findOne(id);
	}

}
