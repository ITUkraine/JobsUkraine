package ua.com.jobsukraine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String goHome(){
		return "home";
	}

	@RequestMapping(value="/login")
	public String goLogin(){
		return "login";
	}
	
	@RequestMapping(value="/contacts")
	public String goContacts(){
		return "contacts";
	}
	
	@RequestMapping(value="/employers")
	public String goEmployers(){
		return "employers";
	}
	
	@RequestMapping(value="/candidates")
	public String goCandidates(){
		return "candidates";
	}
}
