package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
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
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class CandidateServiceTest {

	@Autowired
	private CandidateService candidateService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private Candidate candidate;
	private LoginInfo loginInfo;

	@Before
	public void init() {
		candidate = new Candidate();
		candidate.setName("Vasa");
		candidate.setLastName("Pupkin");
		candidate.setDateOfBirth(new Date());
		candidate.setEmail("pupa@i.ua");
		candidate.setMobileNumber("0631825988");
		candidate.setSex("male");
		candidate.setCityWhereLookingForWork("Lviv");

		loginInfo = new LoginInfo();
		loginInfo.setLogin("vasa");
		loginInfo.setConfirmPassword("123123123");
		loginInfo.setPassword("123123123");

	}

	@Test
	public void isCandidateSaved() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidate", Integer.class) == 0);
			candidateService.save(candidate);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidate", Integer.class) == 1);

		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");

		}

	}

	@Test
	public void isCandidateFind() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");

			assertEquals(candidateService.find(1).getName(), "Vadym");

		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
		}

	}

	@Test
	public void isCandidateFindByLogin() {
		try {
			jdbcTemplate.execute("INSERT INTO logininfo VALUES(1, 'candidate', 'pass', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', 1)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			assertEquals(candidateService.findByLogin("candidate").getInfo().getLogin(), "candidate");
		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

	@Test
	public void isCandidateFindByEmail() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			assertEquals(candidateService.findByEmail("dytyniak@gmail.com").getEmail(), "dytyniak@gmail.com");

		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
		}
	}

	@Test
	public void isCandidateAge() {

		assertEquals(0, candidateService.getAge(candidate));
		Date date = new Date();
		Long timeMonthAgo = date.getTime() + (60 * 60 * 24 * 1000 * 32 * (-1));
		Date dateMonthAgo = new Date(timeMonthAgo);
		candidate.setDateOfBirth(dateMonthAgo);
		assertEquals(-1, candidateService.getAge(candidate));
		Long timeMonthAfter = date.getTime() + (60 * 60 * 24 * 1000 * 31);
		Date dateMonthAfter = new Date(timeMonthAfter);
		candidate.setDateOfBirth(dateMonthAfter);
		assertEquals(0, candidateService.getAge(candidate));

	}

	@Test
	public void isCandidateGetAll() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL),"
							+ "(2, 2, 'knight@gmail.com', 'Knight', '0639631922', 'Trevor', 'male', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1),"
							+ "('Lviv', 'Lviv', NULL, '1970-06-15', '2015-08-20', 'Topcoder', 'NULP', 'Logica', 'Investment', 10, 2)");
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidate", Integer.class) == 2);
			assertTrue(candidateService.getAll().size() == 2);

		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
		}

	}

	@Test
	public void isCandidateRegister() {
		try {
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 0);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidate", Integer.class) == 0);
			Category categories = new Category("Java");
			List<Category> listCategories = new ArrayList<>();
			listCategories.add(categories);
			candidate.setCategories(listCategories);
			candidateService.register(candidate, loginInfo);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 1);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM candidate", Integer.class) == 1);

		} finally {
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

	@Test
	public void isCandidateUpdateGlobalRating() {
		try {
			jdbcTemplate.execute("INSERT INTO logininfo VALUES(1, 'candidate', 'pass', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', 1)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			jdbcTemplate.execute(
					"INSERT INTO feedback VALUES (1, 'Security man', '2015-08-12 09:06:34', '10', NULL, NULL, 1)");

			Candidate candidate = candidateService.findByLogin("candidate");
			assertTrue(candidateService.updateGlobalRating(candidate).getRating() == 10.0);
		} finally {
			jdbcTemplate.execute("DELETE FROM feedback");
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

	@Test
	public void isCandidateGetAvailableVacancies() {
		try {

			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			jdbcTemplate.execute("INSERT INTO category_candidate VALUES (1, 1)");
			jdbcTemplate.execute(
					"INSERT INTO vacancy VALUES (1, 'Full-stack Junior Java developer', 'Junior Java Developer', 400, 1, NULL)");
			List<Vacancy> availableVacancies = candidateService.getAvailableVacancies(candidateService.find(1));
			assertEquals(availableVacancies.get(0).getCategory().getName(),
					candidateService.find(1).getCategories().get(0).getName());
		} finally {
			jdbcTemplate.execute("DELETE FROM vacancy");
			jdbcTemplate.execute("DELETE FROM category_candidate");
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM category");
		}

	}

	@Test
	public void isCandidateGetTopCandidates() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			jdbcTemplate.execute("INSERT INTO category_candidate VALUES (1, 1)");
			jdbcTemplate.execute(
					"INSERT INTO vacancy VALUES (1, 'Full-stack Junior Java developer', 'Junior Java Developer', 400, 1, NULL)");

			List<Candidate> topCandidates1 = candidateService.getTopCandidates(1);
			assertEquals(topCandidates1.get(0).getId(), candidateService.find(1).getId());
			assertTrue(topCandidates1.size() <= 1);

			assertTrue(candidateService.getTopCandidates(5).size() <= 5);
		} finally {
			jdbcTemplate.execute("DELETE FROM vacancy");
			jdbcTemplate.execute("DELETE FROM category_candidate");
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM category");
		}
	}

}
