package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;

public interface CandidateService {
	Candidate add(Candidate candidate);
	void delete(int id);
	Candidate edit(Candidate candidate);
	List<Candidate> getAll();
}
