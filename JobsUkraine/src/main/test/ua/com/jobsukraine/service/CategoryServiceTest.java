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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class CategoryServiceTest {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void isCategoryAdded() {
		try {
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category", Integer.class)==0);
			
			Category category = new Category("Java");
			categoryService.save(category);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category",Integer.class)==1);
			
			categoryService.save(category);
			assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM category",Integer.class)==1);
		} finally {
			jdbcTemplate.execute("DELETE FROM category");
		}
	}

	@Test
	public void isAllCategoriesGetted() {
		try{
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java'),(2, 'HTML')");
			assertTrue(categoryService.getAll().size()==2);
		}finally{
			jdbcTemplate.execute("DELETE FROM category");
		}
	}

	@Test
	public void isCategoryFindedByName() {
		try{
			jdbcTemplate.execute("INSERT INTO category VALUES (1, 'Java')");
			categoryService.findByName("Java");
			assertEquals("Java", categoryService.findByName("Java").getName());
		}finally{
			jdbcTemplate.execute("DELETE FROM category");
		}
	}

}
