package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class EmployerController {

	@Autowired
	private EmployerService es;
	@Autowired
	private LoginInfoService lis;
	@Autowired
	private RoleService rs;
	
	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployer(Map<String, Object> model) {

		model.put("empForm", new Employer());

		return "regEmployer";
	}

	@RequestMapping(value = "/regEmployerNew", method = RequestMethod.POST)
	public String register(@ModelAttribute("empForm")Employer empForm, BindingResult result) {

		
		empForm.getInfo().setRole(rs.findByName("employer"));
		lis.add(empForm.getInfo());
		es.add(empForm);
		return "welcome";

	}

}
