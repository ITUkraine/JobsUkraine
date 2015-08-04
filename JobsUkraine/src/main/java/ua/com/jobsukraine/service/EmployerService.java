package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;

public interface EmployerService extends DefaultService<Employer> {

	Employer findByLogin(String login);
	
	List<Candidate> getAvailableCandidates(List<Category> categories, int top);

}
