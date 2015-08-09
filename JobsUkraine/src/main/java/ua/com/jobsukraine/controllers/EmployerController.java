package ua.com.jobsukraine.controllers;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.SecurityService;

@Controller
@ComponentScan(basePackages = "ua.com.jobsukraine.service")
@SessionAttributes(types = { Employer.class })
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	@Autowired
	private SecurityService ss;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployerLogin(Model model) {

		model.addAttribute("empForm", new Employer());

		return "regemp/RegEmpOne";
	}

	@RequestMapping(value = "/addEmployerInfo", method = RequestMethod.POST)
	public String addEmployerInfo(@ModelAttribute("empForm") Employer emp) {
		return "regemp/RegEmpTwo";

	}

	@RequestMapping(value = "/addEmpCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("empForm") Employer emp, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "regemp/RegEmpTwo";
		} else{
		model.addAttribute("listCat", categoryService.getAll());
		return "regemp/regEmpAddCategory";}
	}

	@RequestMapping(value = "/employerOffice", method = RequestMethod.GET)
	public String goLogin(Principal principal, Model model) {
		String login = principal.getName();
		Employer emp = employerService.findByLogin(login);
		model.addAttribute("employer", emp);
		model.addAttribute("candidates", employerService.getAvailableCandidates(emp.getCategories(), 10));
		return "empOffice/profile";
	}

	@RequestMapping(value = "/addVacancy", method = RequestMethod.GET)
	public String goAddVacancy() {
		return "empOffice/addVacancy";
	}

	@RequestMapping(value = "regEmployerNew", method = RequestMethod.POST)
	public void doAutoLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("empForm") Employer emp) throws IOException {
		String password = emp.getInfo().getPassword();
		ss.encodePassword(emp.getInfo());
		employerService.add(emp);
		ss.autoLoginAfterRegistration(request, response, emp.getInfo().getLogin(), password);
	}
	
	@RequestMapping(value = "/employer/{id}")
	public ModelAndView showEmployerInfoPage(@PathVariable(value = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("employer");
		Employer employer = employerService.find(id);
		modelAndView.addObject("employer", employer);
		return modelAndView;
	}

}
