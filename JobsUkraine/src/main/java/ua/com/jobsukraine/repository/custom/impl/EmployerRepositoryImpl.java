package ua.com.jobsukraine.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.repository.custom.EmployerRepositoryCustom;

public class EmployerRepositoryImpl implements EmployerRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Employer findByLogin(String login) {
		TypedQuery<Employer> query = em.createQuery(
				"SELECT emp FROM Employer emp LEFT JOIN emp.info info WHERE info.login = :login", Employer.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public List<Candidate> getAvailableCandidates(String category, int top) {
		TypedQuery<Object[]> query = em.createQuery(
				"SELECT c,AVG(feedbacks.mark) as AVG_Rating FROM Candidate c JOIN c.feedbacks feedbacks JOIN feedbacks.category ctgr WHERE ctgr.name = :category GROUP BY c.id ORDER BY AVG_Rating DESC",
				Object[].class);
		query.setParameter("category", category);
		List<Candidate> result = new ArrayList<>();
		for (Object o[] : query.getResultList()) {
			((Candidate) o[0]).setRating((Double) o[1]);
			result.add((Candidate) o[0]);
		}
		return result;
	}

}
