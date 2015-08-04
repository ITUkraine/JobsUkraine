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
	private CategoryRepository cr;

	@Override
	public Category add(Category obj) {
		return cr.save(obj);
	}

	@Override
	public void delete(int id) {
		cr.delete(id);
	}

	@Override
	public Category edit(Category obj) {
		return cr.saveAndFlush(obj /* findByName(obj.getName()) */);

	}

	@Override
	public Category find(int id) {
		return cr.findOne(id);
	}

	@Override
	public List<Category> getAll() {
		return cr.findAll();
	}

	@Override
	public Category findByName(String name) {
		return cr.findByName(name);
	}

}
