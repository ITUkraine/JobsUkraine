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

		roleService.add(new Role("ROLE_ADMIN"));
		roleService.add(new Role("ROLE_EMPLOYER"));
		roleService.add(new Role("ROLE_CANDIDATE"));

		catService.add(new Category("Java"));
		catService.add(new Category("HTML"));
		catService.add(new Category("CSS"));
		catService.add(new Category("Pyton"));
		catService.add(new Category("Spring"));
	}
}