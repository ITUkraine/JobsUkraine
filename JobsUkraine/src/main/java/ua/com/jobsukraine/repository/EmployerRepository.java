package ua.com.jobsukraine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	Employer findByLoginInfo(LoginInfo loginInfo);

	@Query("SELECT vacancies FROM Employer emp JOIN emp.vacancy vacancies WHERE emp = ?1")
	List<Vacancy> getVacancies(Employer employer);

	@Query("SELECT c,AVG(feedbacks.mark) as AVG_Rating FROM Candidate c JOIN c.feedbacks feedbacks JOIN feedbacks.category ctgr WHERE ctgr = ?1 GROUP BY c.id ORDER BY AVG_Rating DESC")
	List<Object[]> getAvailableCandidates(Category category);
}