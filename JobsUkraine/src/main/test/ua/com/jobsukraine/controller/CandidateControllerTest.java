package ua.com.jobsukraine.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import ua.com.jobsukraine.controllers.CandidateController;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.SecurityService;
import ua.com.jobsukraine.service.VacancyService;
import ua.com.jobsukraine.utils.PrincipalGenerator;

public class CandidateControllerTest {
	@InjectMocks
	private CandidateController candidateController;

	@Mock
	private SecurityService securityService;
	@Mock
	private CandidateService candidateService;
	@Mock
	private CategoryService categoryService;
	@Mock
	private EmployerService employerService;
	@Mock
	private VacancyService vacancyService;
	@Mock
	private View mockView;
	@Mock
	private Model model;

	private final MockHttpSession session = new MockHttpSession();

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(candidateController).setSingleView(mockView).build();
	}

	@Test
	public void isAddCandidate() throws Exception {
		mockMvc.perform(get("/regCandidate")).andExpect(status().isOk()).andExpect(model().attributeExists("infoForm"))
				.andExpect(model().size(1)).andExpect(view().name("regcandidate/RegCandidateOne"));
	}

	@Test
	public void isAddCandidateCategory() throws Exception {
		session.setAttribute("candidate", new Candidate());
		mockMvc.perform(post("/addCandidateCategory").session(session)).andExpect(status().isOk())
				.andExpect(model().attributeExists("listCat"))
				.andExpect(view().name("regcandidate/regCandidateAddCategory"));
		verify(categoryService, times(1)).getAll();
	}

	@Test
	public void isAddCandidateInfo() throws Exception {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLogin("login");
		// if passwords same
		loginInfo.setPassword("password");
		loginInfo.setConfirmPassword("password");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addCandidateInfo").session(session)).andExpect(status().isOk())
				.andExpect(model().attributeExists("candidate")).andExpect(view().name("regcandidate/RegCandidateTwo"));

		// if passwords diff
		loginInfo.setPassword("passwordDiff");
		loginInfo.setConfirmPassword("password");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addCandidateInfo").session(session)).andExpect(status().isOk())
				.andExpect(model().attributeExists("msg")).andExpect(view().name("regcandidate/RegCandidateOne"));
		// if login validation error
		loginInfo.setLogin("log");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addCandidateInfo").session(session)).andExpect(status().isOk())
				.andExpect(model().attributeExists("msg")).andExpect(view().name("regcandidate/RegCandidateOne"));
	}

	@Test
	public void isAddCandidateInfo2() throws Exception {
		Candidate candidate = new Candidate();
		LoginInfo loginInfo = new LoginInfo();
		candidate.setName("Roman");
		candidate.setLastName("Derckach");
		candidate.setDateOfBirth(new Date());
		candidate.setEmail("pupa@i.ua");
		candidate.setMobileNumber("0631825988");
		candidate.setSex("male");
		candidate.setCityWhereLookingForWork("Lviv");
		candidate.setInfo(loginInfo);
		session.setAttribute("candidate", candidate);
		mockMvc.perform(post("/addCandidateInfo2").session(session))
				.andExpect(view().name("regcandidate/RegCandidateThree"));
		Candidate candidateFalse = new Candidate();
		session.setAttribute("candidate", candidateFalse);
		mockMvc.perform(post("/addCandidateInfo2").session(session))
				.andExpect(view().name("regcandidate/RegCandidateTwo"));
	}

	@Test
	public void testDoAutoLogin() throws Exception {
		try {
			Candidate candidate = new Candidate();
			LoginInfo loginInfo = new LoginInfo();
			session.setAttribute("infoForm", loginInfo);
			session.setAttribute("candidate", candidate);
			mockMvc.perform(post("/regCandidateNew").session(session))
					.andExpect(model().attributeExists("msg", "listCat"))
					.andExpect(view().name("regcandidate/regCandidateAddCategory"));
			verify(categoryService, times(1)).getAll();

			// if employer has any categories
			candidate.setCategories(new ArrayList<>());
			when(candidateService.register(candidate, loginInfo)).thenReturn(new Candidate());
			doNothing().when(securityService).encodePassword(new LoginInfo());
			doNothing().when(securityService).autoLoginAfterRegistration(null, null, null, null);
			mockMvc.perform(post("/regCandidateNew").session(session));
			verify(securityService, times(1)).encodePassword(loginInfo);
			verify(candidateService, times(1)).register(candidate, loginInfo);

		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void isGoLogin() throws Exception {
		try {
			Mockito.when(candidateService.findByLogin("login")).thenReturn(new Candidate());
			mockMvc.perform(get("/candidateOffice")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(view().name("candidateOffice/profile")).andExpect(status().isOk())
					.andExpect(model().attributeExists("candidate", "vacancies"));
			verify(candidateService, times(1)).findByLogin("login");
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void testAcceptVacancy() throws Exception {
		Candidate candidate = new Candidate();
		Vacancy vacancy = new Vacancy();
		Mockito.when(candidateService.findByLogin("login")).thenReturn(candidate);
		Mockito.when(vacancyService.find(1)).thenReturn(vacancy);
		mockMvc.perform(get("/acceptVacancy").param("id", "1")
				.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
				.andExpect(status().isOk()).andExpect(view().name("redirect:vacancy/1")).andExpect(model().size(0));
		verify(candidateService, times(1)).acceptVacancy(candidate, vacancy);
	}

}
