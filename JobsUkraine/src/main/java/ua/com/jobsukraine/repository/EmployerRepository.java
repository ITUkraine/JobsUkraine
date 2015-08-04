package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.repository.custom.EmployerRepositoryCustom;

public interface EmployerRepository extends JpaRepository<Employer, Integer>, EmployerRepositoryCustom {

}