package ua.com.jobsukraine.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.entity.Vacancy;
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
	public String whereToGo(@ModelAttribute("loginForm") LoginInfo loginInfo, Map<String, Object> model,
			RedirectAttributes redirectAttributes) {
		// data which must be available in the next page
		redirectAttributes.addFlashAttribute("loginForm", loginInfo);
		redirectAttributes.addFlashAttribute("msgFromController","msgFromController");
		redirectAttributes.addFlashAttribute("vacancies", new ArrayList<Vacancy>());

		String role = lis.findByLogin(loginInfo.getLogin()).getRole().getName();
		if (role.equals("employer"))
			return "redirect:employerOffice";
		else if (role.equals("candidate"))
			return "redirect:candidateOffice";
		else {
			System.out.println("No role defined for user");
			return "home";
		}
	}

}
