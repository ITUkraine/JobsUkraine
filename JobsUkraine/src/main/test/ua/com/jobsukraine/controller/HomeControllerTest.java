package ua.com.jobsukraine.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import ua.com.jobsukraine.controllers.HomeController;
import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.VacancyService;

public class HomeControllerTest {

	@InjectMocks
	private HomeController homeController;

	@Mock
	private CandidateService candidateService;
	@Mock
	private VacancyService vacancyService;
	@Mock
	private View mockView;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).setSingleView(mockView).build();
	}

	@Test
	public void goToCandidatePage() throws Exception {
		List<Candidate> expectedCandidates = new ArrayList<>();
		when(candidateService.getAll()).thenReturn(expectedCandidates);
		mockMvc.perform(get("/candidates")).andExpect(status().isOk())
				.andExpect(model().attribute("candidates", expectedCandidates)).andExpect(view().name("candidates"));
	}

	@Test
	public void goToHomePage() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("home"));
	}

	@Test
	public void goToContactsPage() throws Exception {
		mockMvc.perform(get("/contacts")).andExpect(status().isOk()).andExpect(view().name("contacts"));
	}

	@Test
	public void goToVacanciesPage() throws Exception {
		List<Vacancy> expectedVacancies = new ArrayList<>();
		when(vacancyService.getAll()).thenReturn(expectedVacancies);
		mockMvc.perform(get("/vacancies")).andExpect(status().isOk())
				.andExpect(model().attribute("vacancies", expectedVacancies)).andExpect(view().name("vacancies"));
	}

	@Test
	public void goToAboutUsPage() throws Exception {
		mockMvc.perform(get("/aboutUs")).andExpect(status().isOk()).andExpect(view().name("aboutUs"));
	}

}
