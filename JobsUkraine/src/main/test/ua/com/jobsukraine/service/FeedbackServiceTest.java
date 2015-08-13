package ua.com.jobsukraine.service;

import static org.junit.Assert.assertTrue;

import java.security.Principal;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Feedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class FeedbackServiceTest {

	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void isVacancyAdded() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category", Integer.class) == 0);
			Principal principal = new Principal() {
				@Override
				public String getName() {
					return "employer";
				}
			};
			jdbcTemplate.execute(
					"INSERT INTO logininfo VALUES (1, 'employer', '$2a$10$oGRxrSk3UTvlC38ZWBaC0.Nx1JM.dMIFooeUsUClkAB7BgUEInjhy', NULL),(2, 'candidate', '$2a$10$xnPq34bvpKMxSkgmPTlUw.3Ygbmfwn/JiHUOrbXwiH0ZIWz.5VrF2', NULL)");
			jdbcTemplate.execute(
					"INSERT INTO person VALUES (2, 1, 'dytyniak@gmail.com', 'Dytyniak', '0639631909', 'Vadym', 'male', 2)");
			jdbcTemplate.execute(
					"INSERT INTO candidate VALUES ('Lviv', 'Lviv', NULL, '1996-06-15', '2015-08-13', 'Topcoder', 'NULP', 'JobsUkraine', 'Java,JPA,Spring', 10, 1)");
			jdbcTemplate.execute(
					"INSERT INTO employer VALUES (1, 'Lviv', 'Recruit company with best of the best IT department', 'jobs@mail.ua', 'JobsUkraine', '093615945632', NULL, 'http://www.jobsukraine.com.ua/', 1)");
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			Feedback feedback = new Feedback();
			feedback.setCategory(new Category("Java"));
			feedbackService.add(candidateService.findByLogin("candidate"), feedback, principal);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM feedback");
			jdbcTemplate.execute("DELETE FROM category");
			jdbcTemplate.execute("DELETE FROM employer");
			jdbcTemplate.execute("DELETE FROM candidate");
			jdbcTemplate.execute("DELETE FROM person");
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

}
