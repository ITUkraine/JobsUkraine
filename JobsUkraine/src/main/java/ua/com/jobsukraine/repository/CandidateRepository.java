package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.repository.custom.CandidateRepositoryCustom;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>, CandidateRepositoryCustom {

	Candidate findByName(String name);
	
}
