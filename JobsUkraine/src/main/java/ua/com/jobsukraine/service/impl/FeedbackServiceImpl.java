package ua.com.jobsukraine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.repository.FeedbackRepository;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.FeedbackService;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public Feedback add(Candidate candidate, Feedback feedback) {
		feedback.setCategory(categoryService.findByName(feedback.getCategory().getName()));
		candidate.getFeedbacks().add(feedback);
		feedbackRepository.saveAndFlush(feedback);
		candidateService.edit(candidate);
		return feedback;
	}

}
