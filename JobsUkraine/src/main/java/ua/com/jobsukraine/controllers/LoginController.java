package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.LoginInfoService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class LoginController {

	@Autowired
	private LoginInfoService lis;

	@RequestMapping(value = "/login")
	public String goLogin(Map<String, Object> model) {
		model.put("loginForm", new LoginInfo());
		return "login";
	}

	// temporary solution for redirection to candidate or employer profile
	@RequestMapping(value = "/loginCheck")
	public String whereToGo(@ModelAttribute("loginForm") LoginInfo loginInfo, Map<String, Object> model) {
		String role = lis.findByLogin(loginInfo.getLogin()).getRole().getName();
		if (role.equals("employer"))
			return "employerOffice";
		else if (role.equals("candidate"))
			return "candidateOffice";
		else {
			System.out.println("No role defined for user");
			return "home";
		}
	}

}
