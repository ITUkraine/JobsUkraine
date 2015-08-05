package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.Vacancy;

public interface VacancyService extends DefaultService<Vacancy> {
	
	Vacancy add(Employer emp, Vacancy obj);
	
}
