package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Employer;

@Controller
public class EmployerController {

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployer(Map<String, Object> model) {

		model.put("empForm", new Employer());

		return "regEmployer";
	}

	@RequestMapping(value = "/regEmployerNew", method = RequestMethod.POST)
	public String register(@ModelAttribute("empForm")Employer empForm, BindingResult result) {

		if (result.hasErrors()) {
			// here you can retrieve form errors of both objects
		}

	

		System.out.println(empForm);

		System.out.println(empForm.getInfo().toString());

		return "welcome";

	}

}
