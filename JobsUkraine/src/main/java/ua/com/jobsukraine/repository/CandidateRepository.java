package ua.com.jobsukraine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	Candidate findByInfo(LoginInfo info);

	@Query("SELECT f FROM Candidate c JOIN c.feedbacks f WHERE c.id = ?1")
	List<Feedback> getFeedbacks(int id);

	@Query("SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f WHERE c.id = ?1")
	Double getGlobalRating(int id);

	@Query("SELECT vacancy FROM Candidate c JOIN c.categories ctgr JOIN ctgr.vacancy vacancy WHERE c.id = ?1")
	List<Vacancy> getAvailableVacancies(int id);

}
