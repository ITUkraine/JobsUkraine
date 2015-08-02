package ua.com.jobsukraine.repository.custom;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateRepositoryCustom {

	public List<Candidate> getByCategoryOrderedByRating(String category, int top);
	
	public double getRating(String login);

	public Candidate findByLogin(String login);
	
	public List<Feedback> getFeedbacks(String login);
	
	public int getAge(String login);
	
	public List<Vacancy> getAvailableVacancies(String login);
	
}
