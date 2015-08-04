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
	private RoleService roleServ;

	@Autowired
	private CategoryService catServ;

	


	@PostConstruct
	public void init() {

		// Creating and saving roles to db

		roleServ.add(new Role("ROLE_ADMIN"));
		roleServ.add(new Role("ROLE_EMPLOYER"));
		roleServ.add(new Role("ROLE_CANDIDATE"));

		// creating and saving categories to db
		catServ.add(new Category("Java"));
		catServ.add(new Category("HTML"));
		catServ.add(new Category("CSS"));
		catServ.add(new Category("Pyton"));
		catServ.add(new Category("Spring"));
	}
}