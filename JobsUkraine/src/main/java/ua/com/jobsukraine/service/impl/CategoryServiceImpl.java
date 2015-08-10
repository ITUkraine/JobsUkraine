package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.repository.CategoryRepository;
import ua.com.jobsukraine.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category add(Category category) {
		if (findByName(category.getName()) == null) {
			return categoryRepository.save(category);
		} else {
			return findByName(category.getName());
		}
	}

	@Override
	public void delete(int id) {
		categoryRepository.delete(id);
	}

	@Override
	public Category edit(Category category) {
		return categoryRepository.saveAndFlush(category);

	}

	@Override
	public Category find(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

}
