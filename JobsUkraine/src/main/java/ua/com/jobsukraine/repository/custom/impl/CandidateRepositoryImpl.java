package ua.com.jobsukraine.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.repository.custom.CandidateRepositoryCustom;

public class CandidateRepositoryImpl implements CandidateRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	// in work
	@Deprecated
	public List<Candidate> getRatingByCategory(String category) {
		// "SELECT f,c,AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN
		// c.feedbacks f GROUP BY c.id ORDER BY AVG_Rating DESC WHERE :category
		// IN (SELECT ) "
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT c,AVG(f.mark), ctgr AS AVG_Rating FROM Candidate c JOIN c.feedbacks f JOIN c.categories ctgr WHERE :category = ctgr.name GROUP BY c.id ORDER BY AVG_Rating DESC",
				Object[].class);
		query.setParameter("category", "admin");
		for (Object o[] : query.getResultList()) {
			System.out.print(((Candidate) o[0]).getName());
			System.out.println("avg: " + (Double) o[1]);
			System.out.println(o[2]);
		}
		// System.out.println(query.getResultList());
		return null;
	}
	
	public double getRating(String login){
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f JOIN c.info info WHERE info.login = :login",
				Object[].class);
		query.setParameter("login", login);
		 System.out.println(query.getSingleResult());
		return 0.0;
	}

	@Override
	public Candidate findByLogin(String login) {
		TypedQuery<Candidate> query = em.createQuery(
				"SELECT c FROM Candidate c LEFT JOIN c.info info WHERE info.login = :login", Candidate.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

}
