package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;

import java.security.Principal;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Feedback;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class FeedbackServiceTest {

	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CandidateService candidateService;

	private Feedback feedback;

	private Category category;

	private Candidate candidate;

	private Feedback feedbackInDB;

	private Principal principal;

	@Before
	public void init() {
		feedback = new Feedback();
		category = new Category("Java");
		principal = new Principal() {

			@Override
			public String getName() {
				return "employer";
			}
		};
		categoryService.save(category);
		candidate = new Candidate();
		candidate.setName("Vasa");
		candidate.setLastName("Pupkin");
		candidate.setDateOfBirth(new Date(0));
		candidate.setEmail("pupa@i.ua");
		candidate.setMobileNumber("0631825988");
		candidate.setSex("male");
		candidate.setCityWhereLookingForWork("Lviv");
		candidateService.save(candidate);
		feedback.setComment("Good one!");
		feedback.setDate(new Date());
		feedback.setMark("10");
		feedback.setCategory(category);

	}

	@Test
	public void isVacancySaved() {
		feedbackInDB = feedbackService.add(candidate, feedback, principal);
		assertEquals(feedbackInDB, feedback);
	}

}
