package ua.com.jobsukraine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import ua.com.jobsukraine.controllers.EmployerController;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;

public class EmployerControllerTest {

	@InjectMocks
	private EmployerController employerController;

	@Mock
	private CategoryService categoryService;
	@Mock
	private EmployerService employerService;
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

	@Test
	public void testShowEmployerInfoPage() throws Exception {
		// if employer not null
		Mockito.when(employerService.find(1)).thenReturn(new Employer());
		mockMvc.perform(get("/employer/1")).andExpect(view().name("employer"));

		// if employer == null
		try {
			Mockito.when(employerService.find(1)).thenReturn(null);
			mockMvc.perform(get("/employer/1")).andExpect(view().name("employer"));
		} catch (Exception e) {
			Assert.assertTrue(e.getMessage().contains("No employer founded"));
		}
	}

}
