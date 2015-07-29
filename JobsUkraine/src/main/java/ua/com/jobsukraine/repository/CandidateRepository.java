package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Candidate;


public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

}
