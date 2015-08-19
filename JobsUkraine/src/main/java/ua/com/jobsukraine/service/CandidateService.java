package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateService {

	Candidate save(Candidate candidate);

	Candidate find(int id);

	Candidate findByLogin(String login);

	Candidate findByEmail(String email);

	int getAge(Candidate candidate);

	List<Vacancy> getAvailableVacancies(Candidate candidate);

	Candidate register(Candidate candidate, LoginInfo info);

	List<Candidate> getAll();

	Candidate updateGlobalRating(Candidate candidate);

	void acceptVacancy(Candidate candidate, Vacancy vacancy);

	List<Candidate> getRandomBestCandidates(Employer employer, int amount, double minRating);
}
