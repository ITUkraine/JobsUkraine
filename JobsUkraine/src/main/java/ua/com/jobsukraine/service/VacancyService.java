package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.Vacancy;

public interface VacancyService {

	void delete(int id);

	Vacancy save(Employer employer, Vacancy vacancy);

	Vacancy find(int id);

	List<Vacancy> getAll();

}
