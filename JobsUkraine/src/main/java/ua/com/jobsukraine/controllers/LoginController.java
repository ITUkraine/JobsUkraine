package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.jobsukraine.entity.LoginInfo;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class LoginController {

	@RequestMapping(value = "/login")
	public String goLogin(Map<String, Object> model) {
		model.put("loginForm", new LoginInfo());
		return "login";
	}

	
	/*@RequestMapping(value = "/j_spring_security_check", method=RequestMethod.POST)
	public String whereToGo() {
		System.out.println("WAW");
		return "candidateOffice";
	}
*/
}
