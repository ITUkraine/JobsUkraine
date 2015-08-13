package ua.com.jobsukraine.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.FeedbackService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;
import ua.com.jobsukraine.service.VacancyService;
import ua.com.jobsukraine.service.impl.CandidateServiceImpl;
import ua.com.jobsukraine.service.impl.CategoryServiceImpl;
import ua.com.jobsukraine.service.impl.EmployerServiceImpl;
import ua.com.jobsukraine.service.impl.FeedbackServiceImpl;
import ua.com.jobsukraine.service.impl.LoginInfoServiceImpl;
import ua.com.jobsukraine.service.impl.RoleServiceImpl;
import ua.com.jobsukraine.service.impl.VacancyServiceImpl;

public class TestConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public RoleService roleService() {
		return new RoleServiceImpl();
	}

	@Bean
	public CandidateService candidateService() {
		return new CandidateServiceImpl();
	}
	
	@Bean
	public EmployerService employerService(){
		return new EmployerServiceImpl();
	}
	
	@Bean
	public CategoryService categoryService(){
		return new CategoryServiceImpl();
	}
	
	@Bean
	public FeedbackService feedbackService(){
		return new FeedbackServiceImpl();
	}
	
	@Bean
	public LoginInfoService loginInfoService(){
		return new LoginInfoServiceImpl();
	}
	
	@Bean
	public VacancyService vacancyService(){
		return new VacancyServiceImpl();
	}

}
