package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.Vacancy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class VacancyServiceTest {

	@Autowired
	private VacancyService vacancyService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EmployerService employerService;

	private Vacancy vacancy;
	
	private Category category;
	
	private Employer employer;
	
	private Vacancy vacancyInDB;
	
	@Before
	public void init(){
		vacancy = new Vacancy();
		category = new Category("Java");
		categoryService.save(category);
		employer = new Employer();
		employer.setName("JobsUkraine");
		employer.setAddress("Lviv");
		employer.setDescription("Gooood");
		employer.setEmail("employer@gmail.com");
		employer.setPhone("0639631909");
		employerService.save(employer);
		vacancy.setName("Senior");
		vacancy.setDescription("Good job");
		vacancy.setSalary(1000);
		vacancy.setCategory(category);
		
	}
	
	@Test
	public void isVacancySaved() {
		vacancyInDB = vacancyService.save(employer, vacancy);
		assertEquals(vacancy, vacancyInDB);
	}
	
	@Test
	public void isVacancyFindById(){
		vacancyInDB =  vacancyService.save(employer,vacancy);
		assertEquals(vacancyService.find(vacancyInDB.getId()), vacancyInDB);
	}
	
	@Test
	public void isVacancyDeleted(){
		vacancyInDB = vacancyService.save(employer,vacancy);
		vacancyService.delete(vacancyInDB.getId());
		assertNull(vacancyService.find(vacancyInDB.getId()));
	}

}
 