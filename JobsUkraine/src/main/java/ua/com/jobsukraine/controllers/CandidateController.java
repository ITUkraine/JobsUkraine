package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Candidate;

@Controller
public class CandidateController {
	
	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Map<String, Object> model) {
		model.put("candidate", new Candidate());
		return "regCandidate";
	}

	@RequestMapping(value = "/regCandidate", method = RequestMethod.POST)
	public String register(@ModelAttribute("candidate") Candidate candidate, BindingResult result) {
		System.out.println(candidate);
		return "welcome";

	}

	
}
