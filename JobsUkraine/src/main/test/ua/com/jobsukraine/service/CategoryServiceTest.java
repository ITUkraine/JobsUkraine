package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Test
	public void isCategoryAdded() {
		Category category = new Category("Java");
		assertNull(category.getId());

		Category addedCategory = categoryService.save(category);
		assertEquals(categoryService.findByName(category.getName()), addedCategory);

		Category addedSameCategoryOneMoreTime = categoryService.save(category);
		assertEquals(addedCategory, addedSameCategoryOneMoreTime);
	}

	@Test
	public void isAllCategoriesGetted() {
		List<Category> addedCategories = new ArrayList<>();
		addedCategories.add(categoryService.save(new Category("Java")));
		addedCategories.add(categoryService.save(new Category("CSS")));

		List<Category> categories = categoryService.getAll();

		for (Category category : addedCategories) {
			assertTrue(categories.contains(category));
		}
	}

	@Test
	public void isCategoryFindedByName() {
		Category addedCategory = categoryService.save(new Category("Java"));
		assertNotNull(addedCategory.getId());

		assertEquals(addedCategory, categoryService.findByName(addedCategory.getName()));
	}

}
