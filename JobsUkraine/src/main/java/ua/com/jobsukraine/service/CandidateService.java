package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateService extends DefaultService<Candidate> {
	Candidate findByName(String name);
	Candidate findByLogin(String login);
	List<Vacancy> getAvailableVacancies(String login);
}
