package ua.com.jobsukraine.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import ua.com.jobsukraine.controllers.AdminController;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.EmployerService;

public class AdminControllerTest {

	@InjectMocks
	private AdminController adminController;

	@Mock
	private View mockView;
	@Mock
	private EmployerService employerService;
	@Mock
	private CandidateService candidateService;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).setSingleView(mockView).build();
	}

	@Test
	public void testGoToAdminPage() throws Exception {
		mockMvc.perform(get("/admin")).andExpect(status().isOk()).andExpect(view().name("admin"))
				.andExpect(model().attributeExists("employers", "candidates")).andExpect(model().size(2));
		verify(employerService, times(1)).getAll();
		verify(candidateService, times(1)).getAll();
	}

}
