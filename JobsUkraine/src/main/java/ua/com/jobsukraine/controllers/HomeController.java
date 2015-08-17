package ua.com.jobsukraine.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.VacancyService;

@Controller
public class HomeController {

	@Autowired
	private CandidateService candidateService;
	@Autowired
	private VacancyService vacancyService;

	@RequestMapping(value = "/aboutUs")
	public String goAboutUs() {
		return "aboutUs";
	}

	@RequestMapping(value = "/candidates")
	public ModelAndView goCandidates() {
		ModelAndView modelAndView = new ModelAndView("candidates");
		List<Candidate> candidates = candidateService.getAll();
		Collections.sort(candidates);
		modelAndView.addObject("candidates", candidates);
		
		modelAndView.addObject("candidateService", candidateService);
		return modelAndView;
	}

	@RequestMapping(value = "/contacts")
	public String goContacts() {
		return "contacts";
	}

	@RequestMapping(value = "/vacancies")
	public ModelAndView goEmployers() {
		ModelAndView modelAndView = new ModelAndView("vacancies");
		List<Vacancy> vacancies = vacancyService.getAll();
		Collections.reverse(vacancies);
		modelAndView.addObject("vacancies", vacancies);
		return modelAndView;
	}

	@RequestMapping(value = "/")
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value = "/join")
	public String goJoin() {
		return "registration";
	}

}
