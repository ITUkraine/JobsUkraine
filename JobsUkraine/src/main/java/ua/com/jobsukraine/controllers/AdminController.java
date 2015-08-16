
package ua.com.jobsukraine.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.EmployerService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class AdminController {
	
	@Autowired
	private EmployerService employerService;
	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping(value="/admin")
	public ModelAndView goAdminPage(){
		ModelAndView modelAndView = new ModelAndView("admin");
		List<Candidate> candidates = candidateService.getAll();
		Collections.sort(candidates);
		modelAndView.addObject("employers", employerService.getAll());
		modelAndView.addObject("candidates", candidates);
		return modelAndView;
	}
}
