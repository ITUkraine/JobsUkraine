package ua.com.jobsukraine.service;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.EmployerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class EmployerServiceTest {
	
	@Mock
	EmployerRepository employerRepository;
	LoginInfo loginInfo = new LoginInfo();
	@Before
	public void initVacancyCorrect() {
		loginInfo.setLogin("Oracle");
		loginInfo.setPassword("11112222");
		loginInfo.setConfirmPassword("11112222");
	}
	
	private Employer employer;
	@Autowired
	private EmployerService employerService;

	public EmployerServiceTest() {
		employer = new Employer();
		employer.setAddress("Lviv");
		employer.setEmail("lol@i.ua");
		employer.setName("Lviv Holod");
		employer.setPhone("111222333");
		employer.setDescription("Coll job");
	}

	@Test
	public void isFindByID() {
		employerService.save(employer);
		int i = employerService.findByLogin("Oracle").getId();
		assertEquals(employerService.find(i).getAddress(), employer.getAddress());
	}

	@Test
	public void isSave() {
		employerService.save(employer);
		assertNotNull(employerService.findByEmail("lol@i.ua"));
	}

	@Test
	public void isFindByLogin() {
		
		employer.setInfo(loginInfo);
		employerService.save(employer);
		assertSame(employerService.findByLogin("Oracle"), employer);
	}

	@Test
	public void isFindByEmail() {
		employerService.save(employer);
		assertSame(employerService.findByEmail("lol@i.ua"), employer);
	}

	@Test
	public void isGetVacancies() {
		List<Vacancy> vacancy = new ArrayList<Vacancy>();
		Vacancy vacancy1 = new Vacancy();
		vacancy1.setDescription("cool job");
		vacancy1.setName("Java");
		vacancy1.setSalary(100);
		vacancy.add(vacancy1);
		vacancy.add(vacancy1);
		vacancy.add(vacancy1);
		employer.setVacancy(vacancy);
		employerService.save(employer);
		System.out.println(vacancy.size());
		assertNotNull(employerService.getVacancies(employer));
	}
	
	@Test
	public void isRegister ()	{
		List<Category> Categories = new ArrayList<Category>();
		Category category = new Category();
		category.setName("Java");
		Categories.add(category);
		employer.setCategories(Categories);
		assertSame(employerService.register(employer, loginInfo), employer);
	}
	
	@Test
	public void isGetAvailableCandidates()	{
	
		
	}
}
