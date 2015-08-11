package ua.com.jobsukraine.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.service.CandidateService;

@Controller
public class HomeController {

	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/")
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/contacts")
	public String goContacts() {
		return "contacts";
	}

	@RequestMapping(value = "/vacancies")
	public String goEmployers() {
		return "vacancies";
	}

	@RequestMapping(value = "/candidates")
	public ModelAndView goCandidates() {
		ModelAndView modelAndView = new ModelAndView("candidates");
		List<Candidate> candidates = candidateService.getAll();
		Collections.sort(candidates);
		modelAndView.addObject("candidates", candidates);
		return modelAndView;
	}

	@RequestMapping(value = "/aboutUs")
	public String goAboutUs() {
		return "aboutUs";
	}

}
