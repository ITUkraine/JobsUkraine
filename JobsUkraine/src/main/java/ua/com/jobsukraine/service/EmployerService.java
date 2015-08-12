package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface EmployerService{

	Employer save(Employer employer);
	
	Employer find(int id);
	
	Employer findByEmail(String email);
	
	Employer findByLogin(String login);
	
	List<Candidate> getAvailableCandidates(Employer employer, int top);

	List<Vacancy> getVacancies(Employer employer);
	
	Employer register(Employer emp, LoginInfo info);
}
