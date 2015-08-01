package ua.com.jobsukraine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.jobsukraine.entity.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {

}
