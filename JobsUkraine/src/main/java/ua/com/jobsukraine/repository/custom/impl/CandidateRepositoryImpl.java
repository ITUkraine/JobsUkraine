package ua.com.jobsukraine.repository.custom.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.entity.Vacancy;
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

	@Override
	public List<Feedback> getFeedbacks(String login) {
		TypedQuery<Feedback> query = em.createQuery(
				"SELECT f FROM Candidate c JOIN c.info info JOIN c.feedbacks f WHERE info.login = :login",
				Feedback.class);
		query.setParameter("login", login);
		return query.getResultList();
	}

	public List<Vacancy> getTenActualVacansy(String login) {
		TypedQuery<Vacancy> query = em.createQuery("SELECT v FROM", Vacancy.class);
		query.setParameter("login", login);
		return null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getAge(String login) {
		TypedQuery<Long> query = em.createQuery(
				"SELECT c.dateOfBirth FROM Candidate c JOIN c.info info WHERE info.login = :login", Long.class);
		query.setParameter("login", login);

		int yearDiff = 0;
		try {
			long dateOfBirth = query.getSingleResult();
			int yearOfBirth = new Date(dateOfBirth).getYear();
			yearDiff = new Date().getYear() - yearOfBirth;

			if (new Date(dateOfBirth).getMonth() > new Date().getMonth()
					&& new Date(dateOfBirth).getDay() > new Date().getDay()) {
				yearDiff--;
			}

		} catch (NullPointerException e) {
		}

		return yearDiff;
	}

	@Override
	public List<Vacancy> getAvailableVacancies(String login) {
		TypedQuery<Vacancy> query = em.createQuery(
				"SELECT vacancy FROM Candidate c JOIN c.categories ctgr JOIN ctgr.vacancy vacancy WHERE c.info.login = :login",
				Vacancy.class);
		query.setParameter("login", login);
		return query.getResultList();
	}

}
