package ua.com.jobsukraine.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import ua.com.jobsukraine.controllers.AdminController;

public class AdminControllerTest {

	@InjectMocks
	private AdminController adminController;

	@Mock
	private View mockView;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).setSingleView(mockView).build();
	}

	@Test
	public void testGoToAdminPage() throws Exception {
		mockMvc.perform(get("/admin")).andExpect(status().isOk()).andExpect(view().name("admin"));
	}

}
