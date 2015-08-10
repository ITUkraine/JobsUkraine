package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateService extends DefaultService<Candidate> {
	Candidate findByLogin(String login);
	
	int getAge(String login);
	
	List<Vacancy> getAvailableVacancies(String login);
	
	Candidate register(Candidate candidate, LoginInfo info);
}
