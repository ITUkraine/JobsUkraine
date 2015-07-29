package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Employer;

public interface EmployerService {
	Employer add(Employer employer);
	void delete(int id);
	Employer edit(Employer employer);
	List<Employer> getAll();
}
