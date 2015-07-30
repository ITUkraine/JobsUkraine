package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Category;

public interface CategoryService extends DefaultService<Category>{
 
	Category findByName(String name);
}
