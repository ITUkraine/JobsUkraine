package ua.com.jobsukraine.repository.custom;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;

public interface CandidateRepositoryCustom {

	public List<Candidate> getByCategoryOrderedByRating(String category, int top);
	
	public double getRating(String login);

	public Candidate findByLogin(String login);
	
}
