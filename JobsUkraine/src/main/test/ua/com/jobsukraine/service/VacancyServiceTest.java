package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
import ua.com.jobsukraine.entity.Vacancy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class VacancyServiceTest {

	@Autowired
	private VacancyService vacancyService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void isVacancySaved() {
		try {
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM vacancy", Integer.class) == 0);
			Vacancy vacancy = new Vacancy();
			vacancy.setName("Senior");
			vacancy.setDescription("Bid salary");
			vacancy.setCategory(new Category("Java"));
			vacancyService.save(null, vacancy);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM vacancy", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM vacancy");
			jdbcTemplate.execute("DELETE FROM category");
		}
	}

	@Test
	public void isVacancyFindById() {
		try {
			jdbcTemplate.execute(
					"INSERT INTO vacancy VALUES (1, 'Full-stack Junior Java developer', 'Junior Java Developer', 3000, NULL, NULL)");
			assertEquals(new Integer(1), vacancyService.find(1).getId());
		} finally {
			jdbcTemplate.execute("DELETE FROM vacancy");
		}
	}

}
