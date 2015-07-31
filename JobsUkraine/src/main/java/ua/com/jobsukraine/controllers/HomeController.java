package ua.com.jobsukraine.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.service.CandidateService;

@Controller
public class HomeController {

	@Autowired
	private CandidateService cs;

	@RequestMapping(value = "/")
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/contacts")
	public String goContacts() {
		return "contacts";
	}

	@RequestMapping(value = "/employers")
	public String goEmployers() {
		return "employers";
	}

	@RequestMapping(value = "/candidates")
	public String goCandidates() {
		return "candidates";
	}

	@RequestMapping(value = "/aboutUs")
	public String goAboutUs() {
		return "aboutUs";
	}
}
