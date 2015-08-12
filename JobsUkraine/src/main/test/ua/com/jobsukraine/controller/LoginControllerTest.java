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

import ua.com.jobsukraine.controllers.LoginController;

public class LoginControllerTest {

	@InjectMocks
	private LoginController loginController;

	@Mock
	private View mockView;

	private MockMvc mockMvc;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(loginController).setSingleView(mockView).build();
	}

	@Test
	public void testGoToLoginPage() throws Exception {
		mockMvc.perform(get("/login")).andExpect(status().isOk()).andExpect(model().attributeExists("loginForm"))
				.andExpect(view().name("login"));
	}

}
