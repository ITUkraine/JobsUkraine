package ua.com.jobsukraine.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.repository.custom.CandidateRepositoryCustom;

public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	// in work
	public List<Candidate> getRatingByCategory(String category) {
		// "SELECT f,c,AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN
		// c.feedbacks f GROUP BY c.id ORDER BY AVG_Rating DESC WHERE :category
		// IN (SELECT ) "
		/*TypedQuery<Object[]> query = em.createQuery(
				"SELECT f,c,AVG(f.mark), ctgr AS AVG_Rating FROM Candidate c JOIN c.feedbacks f JOIN c.categories ctgr GROUP BY c.id ORDER BY AVG_Rating DESC",
				Object[].class);
		// query.setParameter("category", "java");
		for (Object o[] : query.getResultList()) {
			System.out.print((Feedback) o[0]);
			System.out.print((Candidate) o[1]);
			System.out.println("avg: " + (Double) o[2]);
			System.out.println(o[3]);
		}*/
		// System.out.println(query.getResultList());
		return null;
	}

	@Override
	public Candidate findByLogin(String login) {
		TypedQuery<Candidate> query = em.createQuery(
				"SELECT c FROM Candidate c LEFT JOIN c.info info WHERE info.login = :login", Candidate.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

}
