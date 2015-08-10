package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;

public interface FeedbackService {
	Feedback add(Candidate candidate, Feedback feedback);
}
