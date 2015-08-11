package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateService extends DefaultService<Candidate> {
	Candidate findByLogin(String login);
	
	int getAge(Candidate candidate);
	
	List<Vacancy> getAvailableVacancies(Candidate candidate);
	
	Candidate register(Candidate candidate, LoginInfo info);
}
