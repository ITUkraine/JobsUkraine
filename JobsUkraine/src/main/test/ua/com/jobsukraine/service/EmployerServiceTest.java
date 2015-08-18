package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
	private CandidateService candidateService;
	@Autowired
	JdbcTemplate jdbcTemplate;
	Employer employer = new Employer();
	Candidate candidate = new Candidate();
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
	public void isEmployerGetAll() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', NULL),"
							+ "(2, 'dv', 'dvdv', 'e@mail', 'name', '45', NULL, 'dfvdf', NULL)");
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer", Integer.class) == 2);
			assertTrue(employerService.getAll().size() == 2);

		} finally {
			jdbcTemplate.execute("DELETE FROM employer");
		}
	}

	@Test
	public void isConnectWithCandidate() {
		try {
			jdbcTemplate.execute("INSERT INTO logininfo VALUES (1, 'employer', '$2a$10$oGRxrSk3UTvlC38ZWBaC0.Nx1JM.dMIFooeUsUClkAB7BgUEInjhy', NULL),(2, 'candidate', '$2a$10$xnPq34bvpKMxSkgmPTlUw.3Ygbmfwn/JiHUOrbXwiH0ZIWz.5VrF2', NULL)");
			jdbcTemplate.execute("INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', 2)");
			jdbcTemplate.execute("INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			jdbcTemplate.execute("INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', 1)");
			employerService.connectWithCandidate(candidateService.find(1), employerService.find(1));
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer_candidate", Integer.class) == 1);
			employerService.connectWithCandidate(candidateService.find(1), employerService.find(1));
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM employer_candidate", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM employer_candidate");
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM employer");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}
}
