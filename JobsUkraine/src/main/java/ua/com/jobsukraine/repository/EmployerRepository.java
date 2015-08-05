package ua.com.jobsukraine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.custom.EmployerRepositoryCustom;

public interface EmployerRepository extends JpaRepository<Employer, Integer>, EmployerRepositoryCustom {

	Employer findByInfo(LoginInfo info);
	
	@Query("SELECT vacancies FROM Employer emp JOIN emp.vacancy vacancies WHERE emp.id = ?1")
	List<Vacancy> getVacancies(int id);
	
}