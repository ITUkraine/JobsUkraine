package ua.com.jobsukraine.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Role;

@Service
@Transactional
public class InitService {
	@Autowired
	private RoleService roleService;

	@Autowired
	private CategoryService catService;

	@PostConstruct
	public void init() {

		roleService.save(new Role("ROLE_ADMIN"));
		roleService.save(new Role("ROLE_EMPLOYER"));
		roleService.save(new Role("ROLE_CANDIDATE"));

		catService.save(new Category("Java"));
		catService.save(new Category("HTML"));
		catService.save(new Category("CSS"));
		catService.save(new Category("Pyton"));
		catService.save(new Category("Spring"));
	}
}