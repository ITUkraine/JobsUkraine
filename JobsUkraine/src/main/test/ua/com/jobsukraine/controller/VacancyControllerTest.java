package ua.com.jobsukraine.controller;

import static org.mockito.Mockito.doNothing;
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
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.NestedServletException;

import ua.com.jobsukraine.controllers.VacancyController;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Role;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.VacancyService;
import ua.com.jobsukraine.utils.PrincipalGenerator;

@EnableWebMvc
public class VacancyControllerTest {

	@InjectMocks
	private VacancyController vacancyController;

	@Mock
	private LoginInfoService loginInfoService;
	@Mock
	private VacancyService vacancyService;
	@Mock
	private EmployerService employerService;
	@Mock
	private CategoryService categoryService;
	@Mock
	private Employer employer;
	@Mock
	private View mockView;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(vacancyController).setSingleView(mockView).build();
	}

	@Test
	public void testDeleteVacancy() throws Exception {
		try {
			// if admin
			doNothing().when(vacancyService).delete(1);

			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setRole(new Role("ROLE_ADMIN"));
			when(loginInfoService.findByLogin("login")).thenReturn(loginInfo);

			mockMvc.perform(get("/vacancy/delete").param("id", "1")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(view().name("redirect:/vacancies")).andExpect(status().isOk());

			// if users
			LoginInfo loginInfo2 = new LoginInfo();
			loginInfo2.setRole(new Role("ROLE_CANDIDATE"));
			when(loginInfoService.findByLogin("login")).thenReturn(loginInfo2);

			mockMvc.perform(get("/vacancy/delete").param("id", "1")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_CANDIDATE" })))
					.andExpect(view().name("redirect:/empOffice/addVacancy")).andExpect(status().isOk());
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void testGoToAddVacancy() throws Exception {
		try {
			when(vacancyService.save(new Employer(), new Vacancy())).thenReturn(new Vacancy());
			mockMvc.perform(post("/empOffice/addVacancy")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(view().name("redirect:/empOffice/addVacancy")).andExpect(status().isOk());
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test
	public void testGoAddVacancyPage() throws Exception {
		try {
			when(employerService.findByLogin("login")).thenReturn(new Employer());
			when(categoryService.getAll()).thenReturn(new ArrayList<>());
			mockMvc.perform(get("/empOffice/addVacancy")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(view().name("empOffice/addVacancy")).andExpect(status().isOk());
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

	@Test(expected = NestedServletException.class)
	public void testShowVacancyInfoPage() throws Exception {
		try {
			// if vacancy exist
			when(vacancyService.find(1)).thenReturn(new Vacancy());
			mockMvc.perform(get("/vacancy/1").param("id", "1")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })))
					.andExpect(view().name("vacancy")).andExpect(model().attributeExists("vacancy"))
					.andExpect(status().isOk());

			// if vacancy doesn't exist
			when(vacancyService.find(1)).thenReturn(null);
			mockMvc.perform(get("/vacancy/1").param("id", "1")
					.principal(PrincipalGenerator.getPrincipal("login", "", new String[] { "ROLE_ADMIN" })));
		} finally {
			SecurityContextHolder.clearContext();
		}
	}

}
