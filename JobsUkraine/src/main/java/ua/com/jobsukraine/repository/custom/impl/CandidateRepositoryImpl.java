package ua.com.jobsukraine.repository.custom.impl;

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
	public double getRating(String login) {
		TypedQuery<Double> query = em.createQuery(
				"SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f JOIN c.info info WHERE info.login = :login",
				Double.class);
		query.setParameter("login", login);
		try {
			return query.getSingleResult();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public double getRating(int id) {
		TypedQuery<Double> query = em.createQuery(
				"SELECT AVG(f.mark) AS AVG_Rating FROM Candidate c JOIN c.feedbacks f WHERE c.id = :id", Double.class);
		query.setParameter("id", id);
		try {
			return query.getSingleResult();
		} catch (NullPointerException e) {
			e.printStackTrace();
			return 0;
		}
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
			e.printStackTrace(); // if no date of birth is founded
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
