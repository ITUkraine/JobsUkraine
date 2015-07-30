package ua.com.jobsukraine.repository.custom.impl;

import java.util.ArrayList;
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
	public List<Candidate> getByCategoryOrderedByRating(String category, int top) {
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT c, AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.info info JOIN c.feedbacks f WHERE f.category.name = :category GROUP BY info.login ORDER BY AVG_Rating DESC",
				Object[].class);
		query.setParameter("category", category);
		query.setMaxResults(top);
		List<Candidate> result = new ArrayList<>(top);
		for (Object o[] : query.getResultList()) {
			((Candidate) o[0]).setRating((Double) o[1]);
			result.add((Candidate) o[0]);
		}
		return result;
	}

	@Override
	public double getRating(String login) {
		TypedQuery<Double> query = em.createQuery(
				"SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f JOIN c.info info WHERE info.login = :login",
				Double.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public Candidate findByLogin(String login) {
		TypedQuery<Candidate> query = em.createQuery(
				"SELECT c FROM Candidate c LEFT JOIN c.info info WHERE info.login = :login", Candidate.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

}
