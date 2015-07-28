package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, String> {

}