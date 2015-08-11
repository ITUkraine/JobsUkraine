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
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.SecurityService;

@Controller
@ComponentScan(basePackages = "ua.com.jobsukraine.service")
@SessionAttributes(types = { Employer.class, LoginInfo.class })
public class EmployerController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private SecurityService securityService;

	@RequestMapping(value = "/addEmpCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("empForm") Employer emp, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "regemp/RegEmpTwo";
		} else {
			model.addAttribute("listCat", categoryService.getAll());
			return "regemp/regEmpAddCategory";
		}
	}

	@RequestMapping(value = "/addEmployerInfo", method = RequestMethod.POST)
	public String addEmployerInfo(@Valid @ModelAttribute("infoForm") LoginInfo info, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "regemp/RegEmpOne";
		} else {
			model.addAttribute("empForm", new Employer());
			return "regemp/RegEmpTwo";
		}

	}

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployerLogin(Model model) {

		model.addAttribute("infoForm", new LoginInfo());

		return "regemp/RegEmpOne";
	}

	@RequestMapping(value = "regEmployerNew", method = RequestMethod.POST)
	public void doAutoLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("empForm") Employer emp, @ModelAttribute("infoForm") LoginInfo info) throws IOException {
		String password = info.getPassword();
		securityService.encodePassword(info);
		employerService.register(emp, info);
		securityService.autoLoginAfterRegistration(request, response, info.getLogin(), password);
	}

	@RequestMapping(value = "/addVacancy", method = RequestMethod.GET)
	public String goAddVacancy() {
		return "empOffice/addVacancy";
	}

	@RequestMapping(value = "/employerOffice", method = RequestMethod.GET)
	public String goLogin(Principal principal, Model model) {
		String login = principal.getName();
		Employer employer = employerService.findByLogin(login);
		model.addAttribute("employer", employer);
		model.addAttribute("candidates", employerService.getAvailableCandidates(employer.getCategories(), 10));
		return "empOffice/profile";
	}

	@RequestMapping(value = "/employer/{id}")
	public ModelAndView showEmployerInfoPage(@PathVariable(value = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("employer");
		Employer employer = employerService.find(id);
		modelAndView.addObject("employer", employer);
		return modelAndView;
	}

	@RequestMapping(value = "/employerOffice/edit")
	public ModelAndView edit() {
		ModelAndView modelAndView = new ModelAndView("empOffice/edit");
		return modelAndView;
	}
}
