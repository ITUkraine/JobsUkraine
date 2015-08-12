package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Category;

public interface CategoryService{
 
	Category save(Category category);
	
	Category findByName(String name);
	
	List<Category> getAll();
}
