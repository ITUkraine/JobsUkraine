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
import org.springframework.web.servlet.View;
import org.springframework.web.util.NestedServletException;

import ua.com.jobsukraine.controllers.EmployerController;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.SecurityService;
import ua.com.jobsukraine.utils.PrincipalGenerator;

public class EmployerControllerTest {

	@InjectMocks
	private EmployerController employerController;

	@Mock
	private CategoryService categoryService;
	@Mock
	private EmployerService employerService;
	@Mock
	private SecurityService securityService;
	@Mock
	private CandidateService candidateService;
	@Mock
	private Employer employerMock;
	@Mock
	private LoginInfo loginInfoMock;
	@Mock
	private View mockView;

	private final MockHttpSession session = new MockHttpSession();

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employerController).setSingleView(mockView).build();
	}

	@Test
	public void testGoToRegEmployerPage() throws Exception {
		mockMvc.perform(get("/regEmployer")).andExpect(status().isOk()).andExpect(model().attributeExists("infoForm"))
				.andExpect(model().size(1)).andExpect(view().name("regemp/RegEmpOne"));
	}

	@Test
	public void testGoToAddEmployerInforPage() throws Exception {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLogin("login");
		// if passwords same
		loginInfo.setPassword("password");
		loginInfo.setConfirmPassword("password");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addEmployerInfo").session(session)).andExpect(view().name("regemp/RegEmpTwo"));
		// if passwords diff
		loginInfo.setPassword("passwordDiff");
		loginInfo.setConfirmPassword("password");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addEmployerInfo").session(session)).andExpect(view().name("regemp/RegEmpOne"));
		// if login validation error
		loginInfo.setLogin("log");
		session.setAttribute("infoForm", loginInfo);
		mockMvc.perform(post("/addEmployerInfo").session(session)).andExpect(view().name("regemp/RegEmpOne"));
	}

	@Test
	public void testGoToAddCategoryPage() throws Exception {
		// with validation errors
		session.setAttribute("infoForm", new LoginInfo());
		session.setAttribute("empForm", new Employer());
		mockMvc.perform(post("/addEmpCategory").session(session)).andExpect(view().name("regemp/RegEmpTwo"));

		// without validation errors
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setLogin("GOOGLE");
		loginInfo.setPassword("111222333");
		loginInfo.setConfirmPassword("111222333");
		Employer employer = new Employer();
		employer.setName("Google");
		employer.setAddress("Lviv");
		employer.setEmail("google@com.ua");
		employer.setDescription("Cool!");
		employer.setPhone("112233");
		employer.setInfo(loginInfo);
		session.setAttribute("infoForm", loginInfo);
		session.setAttribute("empForm", employer);
		Mockito.when(categoryService.getAll()).thenReturn(new ArrayList<>());
		mockMvc.perform(post("/addEmpCategory").session(session)).andExpect(model().attributeExists("listCat"))
				.andExpect(view().name("regemp/regEmpAddCategory"));
	}

	@Test
	public void testGoToAddVacancy() throws Exception {
		mockMvc.perform(get("/addVacancy")).andExpect(view().name("empOffice/addVacancy"));
	}

	@Test(expected = NestedServletException.class)
	public void testShowEmployerInfoPage() throws Exception {
		// if employer not null
		Mockito.when(employerService.find(1)).thenReturn(new Employer());
		mockMvc.perform(get("/employer/1")).andExpect(view().name("employer"));

		// if employer == null
		Mockito.when(employerService.find(1)).thenReturn(null);
		mockMvc.perform(get("/employer/1")).andExpect(view().name("employer"));
	}

	@Test
	public void testDoAutoLogin() throws Exception {
		try {
			Employer employer = new Employer();
			LoginInfo loginInfo = new LoginInfo();
			session.setAttribute("infoForm", loginInfo);
			session.setAttribute("empForm", employer);

			// if employer hasn't got any categories
			when(categoryService.getAll()).thenReturn(new ArrayList<>());
			mockMvc.perform(post("/regEmployerNew").session(session))
					.andExpect(view().name("regemp/regEmpAddCategory"));

			// if employer has any categories
			employer.setCategories(new ArrayList<>());
			when(employerService.register(employer, loginInfo)).thenReturn(new Employer());
			doNothing().when(securityService).encodePassword(new LoginInfo());
			doNothing().when(securityService).autoLoginAfterRegistration(null, null, null, null);
			mockMvc.perform(post("/regEmployerNew").session(session));
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void testGoLogin() throws Exception {
		try {
			when(employerService.findByLogin("login")).thenReturn(new Employer());
			when(candidateService.getTopCandidates(5)).thenReturn(new ArrayList<>());
			mockMvc.perform(get("/employerOffice")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(model().attributeExists("employer", "candidateService", "candidates"))
					.andExpect(model().size(3)).andExpect(view().name("empOffice/profile"));
			verify(employerService, times(1)).findByLogin("login");
			verify(candidateService, times(1)).getTopCandidates(5);
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void testConnectEmployerCandidate() throws Exception {
		Candidate candidate = new Candidate();
		Employer employer = new Employer();
		Mockito.when(employerService.findByLogin("login")).thenReturn(employer);
		Mockito.when(candidateService.find(1)).thenReturn(candidate);
		mockMvc.perform(get("/connectEmployerCandidate").param("id", "1")
				.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
				.andExpect(status().isOk()).andExpect(view().name("redirect:candidate/1")).andExpect(model().size(0));
		verify(employerService, times(1)).connectWithCandidate(candidate, employer);
	}
}
