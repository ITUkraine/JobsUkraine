package ua.com.jobsukraine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

	Candidate findByLoginInfo(LoginInfo loginInfo);

	@Query("SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f WHERE c = ?1")
	Double getGlobalRating(Candidate candidate);

	@Query("SELECT vacancy FROM Candidate c JOIN c.categories ctgr JOIN ctgr.vacancy vacancy WHERE c = ?1")
	List<Vacancy> getAvailableVacancies(Candidate candidate);

	List<Candidate> findAll();

	Candidate findByEmail(String email);
	
	@Query("SELECT DISTINCT c FROM Candidate c JOIN c.categories ctgr WHERE ctgr = ?1 AND c.rating>=?2")
	List<Candidate> findByRatingGreaterThan(Category category, double value);
}
