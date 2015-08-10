package ua.com.jobsukraine.service;

import java.security.Principal;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;

public interface FeedbackService {
	Feedback add(Candidate candidate, Feedback feedback, Principal principal);
}
