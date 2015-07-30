package ua.com.jobsukraine.repository.custom;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;

public interface CandidateRepositoryCustom {

	public List<Candidate> getRatingByCategory(String category);

	public Candidate findByLogin(String login);
	
}
