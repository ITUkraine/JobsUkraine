package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Candidate;

public interface CandidateService extends DefaultService<Candidate> {
	Candidate findByName(String name);
	Candidate fingByLogin(String login);
}
