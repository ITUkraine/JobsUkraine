package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.LoginInfo;

@Controller
public class CandidateController {
	
	@RequestMapping(value="/regCandidate", method=RequestMethod.GET)
	public String goRegCandidate(Model model) {
		Candidate candidate = new Candidate();
		model.addAttribute("candidate", candidate);
		return "regCandidate";
	}
	
	@RequestMapping(value="/regCandidate", method=RequestMethod.POST)
	public String regCandidate(@ModelAttribute("candidate") Candidate candidate,
								BindingResult bindingResult){
		System.out.println(candidate);
		return "welcome";
	}
	
}
