package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class LoginController {

	@Autowired
	private CandidateService cs;
	
	@RequestMapping(value="/login")
	public String goLogin(Map<String,Object> model){
		model.put("loginForm",new LoginInfo());
		return "login";
	}
	
}
