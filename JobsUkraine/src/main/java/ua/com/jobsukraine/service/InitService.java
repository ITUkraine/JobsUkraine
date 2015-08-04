package ua.com.jobsukraine.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Role;

@Service
@Transactional
public class InitService {
	@Autowired
	private RoleService roleServ;

	@Autowired
	private CategoryService catServ;

	@Autowired
	private CandidateService canServ;
	
	@Autowired
	private EmployerService empServ;
	
	@Autowired
	private VacancyService vacServ;
	
	@Autowired
	private LoginInfoService logServ;

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

		// creating and saving emp to db
		//fucking validations!!!
		/*Candidate candidate1 = new Candidate("Lviv", "Lviv", "CV1", new Date(), new Date(), "JobsUkraine", "Politex",
				"I do");
		LoginInfo loginInf1 = new LoginInfo("candidate", "candidate");
		loginInf1.setConfirmPassword("candidate");
		loginInf1.setRole(roleServ.findByName("ROLE_CANDIDATE"));
		candidate1.setInfo(loginInf1);
		candidate1.setEmail("superman@com.ua");
		candidate1.setMobileNumber("0631927233");
		candidate1.setName("Klark");
		candidate1.setLastName("Kent");
		candidate1.setSex("male");
		List<Category> catList1 = new ArrayList<>();
		catList1.add(catServ.findByName("Java"));
		catList1.add(catServ.findByName("HTML"));
		catList1.add(catServ.findByName("CSS"));
		candidate1.setCategories(catList1);
		logServ.add(loginInf1);
		canServ.add(candidate1);
		for (Category category : catList1) {
			category.getCandidates().add(candidate1);
			catServ.edit(category);
		}*/

	}

}
