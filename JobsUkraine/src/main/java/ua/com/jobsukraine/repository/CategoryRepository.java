package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
  
	Category findByName(String name);
}
