package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Category;

public interface CategoryService extends DefaultService<Category>{
 
	Category findByName(String name);
	
	List<Category> getAll();
}
