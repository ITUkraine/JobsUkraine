package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
@TransactionConfiguration
public class CandidateServiceTest {

	@Autowired
	private CandidateService candidateService;
	@Autowired 
	private VacancyService vacancyService;
	
	private LoginInfo loginInfo;
	private Candidate candidate;
	private Vacancy vacancy;
	private Employer employer;
	@Before
	public void init() {
		candidate = new Candidate();
		candidate.setName("Vasa");
		candidate.setLastName("Pupkin");
		candidate.setDateOfBirth(new Date(0));
		candidate.setEmail("pupa@i.ua");
		candidate.setMobileNumber("0631825988");
		candidate.setSex("male");
		candidate.setCityWhereLookingForWork("Lviv");
		loginInfo = new LoginInfo();
		loginInfo.setLogin("vasa");
		loginInfo.setConfirmPassword("123123123");
		loginInfo.setPassword("123123123");
		candidate.setInfo(loginInfo);
		
		
	    vacancy = new Vacancy();
		vacancy.setName("Senior");
		vacancy.setDescription("Good job");
		vacancy.setSalary(1000);
		  
	}

	@Test
	public void isCandidateSaved() {
		assertNull(candidate.getId());
		Candidate addedCandidate = candidateService.save(candidate);
		assertNotNull(candidate.getId());
		assertEquals(candidate.getName(), addedCandidate.getName());
	}

	@Test
	public void isCandidateFind() {
		Candidate addedCandidate = candidateService.save(candidate);
		Candidate findedCandidate = candidateService.find(addedCandidate.getId());
		assertEquals(addedCandidate.getId(), findedCandidate.getId());
	}

	@Test
	public void isCandidateFindByLogin() {
		Candidate addedCandidate = candidateService.save(candidate);
		Candidate findedCandidate = candidateService.findByLogin(addedCandidate.getInfo().getLogin());
		assertEquals(addedCandidate.getInfo().getLogin(), findedCandidate.getInfo().getLogin());

	}

	@Test
	public void isCandidateFindByEmail() {
		Candidate addedCandidate = candidateService.save(candidate);
		Candidate findedCandidate = candidateService.findByEmail(addedCandidate.getEmail());
		assertEquals(addedCandidate.getEmail(), findedCandidate.getEmail());

	}
	
	@Test
	public void isCandidateAge() {
	     int age = 45;
	     int candidateAge = candidateService.getAge(candidate);
	     assertEquals(age, candidateAge);
	     
	}
	
	@Test
	public void isCandidateGetAll(){
		
		Candidate candidate2 = new Candidate();
		candidate2.setName("Mupa");
		candidate2.setLastName("Mupkina");
		candidate2.setDateOfBirth(new Date(0));
		candidate2.setEmail("mupa@i.ua");
		candidate2.setMobileNumber("0631825945");
		candidate2.setSex("female");
		candidate2.setCityWhereLookingForWork("Lviv");
		List<Candidate> listCandidats = new ArrayList<>();
		listCandidats.add(candidateService.save(candidate));
		listCandidats.add(candidateService.save(candidate2));
		List<Candidate> listFindedCandidats = candidateService.getAll();
		assertTrue(listCandidats.containsAll(listFindedCandidats));
		
	}
	
}
