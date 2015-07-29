package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.form.EmployerForm;

@Controller
public class EmployerController {

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployer(Map<String, Object> model) {
		// LoginInfo li = new LoginInfo();
		// Candidate candidate = new Candidate();
		//
		// model.addAttribute("loginInfo", li);
		// model.addAttribute("candidate", candidate);

		model.put("empForm", new EmployerForm());

		return "regEmployer";
	}

	@RequestMapping(value = "/regEmployerNew", method = RequestMethod.POST)
	public String register(@ModelAttribute("empForm")EmployerForm empForm, BindingResult result) {

		if (result.hasErrors()) {
			// here you can retrieve form errors of both objects
		}

		LoginInfo info = empForm.getInfo();
		Employer emp = empForm.getEmp();

		System.out.println(info);
		System.out.println(emp);

		return "welcome";

	}

}
