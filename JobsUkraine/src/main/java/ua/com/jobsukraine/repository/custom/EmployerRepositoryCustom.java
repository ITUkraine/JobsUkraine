package ua.com.jobsukraine.repository.custom;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Employer;

public interface EmployerRepositoryCustom {

	public Employer findByLogin(String login);
	
	public List<Candidate> getAvailableCandidates(String category, int top);

}
