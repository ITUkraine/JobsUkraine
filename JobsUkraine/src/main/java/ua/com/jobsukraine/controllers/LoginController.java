package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.LoginInfo;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String goLogin(Map<String,Object> model){
		model.put("loginForm",new LoginInfo());
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String goLogin(@ModelAttribute("loginForm") LoginInfo loginInfo){
		System.out.println(loginInfo);
		return "welcome";
	}
}
