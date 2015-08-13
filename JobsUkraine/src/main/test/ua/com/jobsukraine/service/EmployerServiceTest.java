package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class EmployerServiceTest {

	@Autowired
	private EmployerService employerService;

	@Autowired
	JdbcTemplate jdbcTemplate;
	Employer employer = new Employer();
	LoginInfo loginInfo = new LoginInfo();

	@Before
	public void init() {

		employer.setName("Google");
		employer.setAddress("Lviv");
		employer.setEmail("google@com.ua");
		employer.setDescription("Cool!");
		employer.setPhone("112233");
		loginInfo.setLogin("GOOGLE");
		loginInfo.setPassword("111222333");
		loginInfo.setConfirmPassword("111222333");
		employer.setInfo(loginInfo);
	}

	@Test
	public void isEmployerAdded() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			employerService.save(employer);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 1);
			employerService.save(employer);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}

	@Test
	public void isFindByID() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', NULL)");
			assertEquals(employerService.find(1).getName(), "JobsUkraine");
		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}

	@Test
	public void isFindByEmail() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', NULL)");
			assertEquals(employerService.findByEmail("jobs@mail.ua").getName(), "JobsUkraine");
		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}

	@Test
	public void isFindByLogin() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			jdbcTemplate.execute(
					"INSERT INTO logininfo VALUES (1, 'employer', '$2a$10$oGRxrSk3UTvlC38ZWBaC0.Nx1JM.dMIFooeUsUClkAB7BgUEInjhy', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', 1)");
			assertEquals(employerService.findByLogin("employer").getName(), "JobsUkraine");

		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}

	@Test
	public void isGetAvailableCandidates() {
		try {
//			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
//			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java'),(2, 'HTML'),(3, 'CSS'),(4, 'Pyton'),(5, 'Spring')");
//			jdbcTemplate.execute("INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', NULL)");
//			jdbcTemplate.execute("INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL),(2, 2, 'knight@gmail.com', 'Knight', '0639631922', 'Trevor', 'male', NULL)");
//			jdbcTemplate.execute("INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1),('Lviv', 'Lviv', NULL, '1970-06-15', '2015-08-20', 'Topcoder', 'NULP', 'Logica', 'Investment', 10, 2)");
//			jdbcTemplate.execute("INSERT INTO category_candidate VALUES (1, 1),(1, 2),(1, 5),(2, 1)");
//			jdbcTemplate.execute("INSERT INTO category_employer VALUES (1, 1),(1, 5)");
//			jdbcTemplate.execute("INSERT INTO feedback VALUES (1, 'Security man', '2015-08-12 09:06:34', '10', 5, 1, 1),(2, 'Good one)', '2015-08-12 10:13:31', '10', 1, 1, 2),(3, 'Niiiiiice)', '2015-08-12 15:26:55', '10', 1, 1, 2),(4, 'Goood', '2015-08-12 15:36:36', '10', 1, 1, 2)");
//			jdbcTemplate.execute("INSERT INTO vacancy VALUES (1, 'Full-stack Junior Java developer', 'Junior Java Developer', 400, 1, 1)");
//			
//			List<Candidate> listCandidate = employerService.getAvailableCandidates(employerService.find(1), 4);
//			assertNotNull(listCandidate.size());
			
		} finally {
//			jdbcTemplate.execute("DELETE FROM category_candidate");
//			jdbcTemplate.execute("DELETE FROM category_employer");
//			jdbcTemplate.execute("DELETE FROM vacancy");
//			jdbcTemplate.execute("DELETE FROM feedback");
//			jdbcTemplate.execute("DELETE FROM candidate");
//			jdbcTemplate.execute("DELETE FROM person");
//			jdbcTemplate.execute("DELETE FROM employer");
//			jdbcTemplate.execute("DELETE FROM category");
		}
	}

	@Test
	public void isRegister() {
		try {
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 0);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			Category categories = new Category("Java");
			List<Category> listCategories = new ArrayList<>();
			listCategories.add(categories);
			employer.setCategories(listCategories);
			employerService.register(employer, loginInfo);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 1);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 1);

		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

	@Test
	public void isGetVacancies() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 0);
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO vacancy VALUES (1, 'Full-stack Junior Java developer', 'Junior Java Developer', 400, NULL, 1)");
			jdbcTemplate.execute(
					"INSERT INTO vacancy VALUES (2, 'Full-stack Junior Java developer', 'Junior Java Developer', 500, NULL, 1)");

			assertTrue(employerService.getVacancies(employerService.find(1)).size() == 2);
		} finally {
			jdbcTemplate.execute("DELETE FROM vacancy");
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}
}
