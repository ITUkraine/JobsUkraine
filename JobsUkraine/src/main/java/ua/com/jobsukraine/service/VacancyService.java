package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.Vacancy;

public interface VacancyService {
	
	void delete(int id);
	
	Vacancy save(Vacancy vacancy);
	
	Vacancy find(int id);
	
	Vacancy add(Employer emp, Vacancy obj);
	
}
