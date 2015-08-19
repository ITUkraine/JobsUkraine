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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.exceptions.CustomMessageException;
import ua.com.jobsukraine.service.CandidateService;
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
	@Autowired
	private CandidateService candidateService;

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployerLogin(Model model) {
		model.addAttribute("infoForm", new LoginInfo());
		return "regemp/RegEmpOne";
	}

	@RequestMapping(value = "/addEmployerInfo", method = RequestMethod.POST)
	public String addEmployerInfo(@Valid @ModelAttribute("infoForm") LoginInfo loginInfo, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			if (!loginInfo.getPassword().equals(loginInfo.getConfirmPassword())) {
				model.addAttribute("msg", "Passwords must be identical");
			}
			return "regemp/RegEmpOne";
		} else {
			if (!loginInfo.getPassword().equals(loginInfo.getConfirmPassword())) {
				model.addAttribute("msg", "Passwords must be identical");
				return "regemp/RegEmpOne";
			} else {
				model.addAttribute("empForm", new Employer());
				return "regemp/RegEmpTwo";
			}
		}
	}

	@RequestMapping(value = "/addEmpCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("empForm") Employer employer, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "regemp/RegEmpTwo";
		} else {
			model.addAttribute("listCat", categoryService.getAll());
			return "regemp/regEmpAddCategory";
		}
	}

	@RequestMapping(value = "regEmployerNew", method = RequestMethod.POST)
	public String doAutoLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("empForm") Employer employer, @ModelAttribute("infoForm") LoginInfo loginInfo, Model model)
					throws IOException {
		if (employer.getCategories() == null) {
			model.addAttribute("msg", "Please, select at least one category");
			model.addAttribute("listCat", categoryService.getAll());
			return "regemp/regEmpAddCategory";
		} else {
			String password = loginInfo.getPassword();
			securityService.encodePassword(loginInfo);
			employerService.register(employer, loginInfo);
			securityService.autoLoginAfterRegistration(request, response, loginInfo.getLogin(), password);
		}
		return null;
	}

	@RequestMapping(value = "/addVacancy", method = RequestMethod.GET)
	public String goAddVacancy() {
		return "empOffice/addVacancy";
	}

	@RequestMapping(value = "/employerOffice", method = RequestMethod.GET)
	public String goLogin(Principal principal, Model model) {
		model.addAttribute("employer", employerService.findByLogin(principal.getName()));
		model.addAttribute("candidateService", candidateService);
		System.err.println(candidateService.findByLogin(principal.getName()));
		model.addAttribute("candidates",
				candidateService.getRandomBestCandidates(employerService.findByLogin(principal.getName()), 3, 6));
		return "empOffice/profile";
	}

	@RequestMapping(value = "/employer/{id}")
	public ModelAndView showEmployerInfoPage(@PathVariable(value = "id") int id) {
		ModelAndView modelAndView = new ModelAndView("employer");
		Employer employer = employerService.find(id);
		if (employer == null) {
			throw new CustomMessageException("No employer founded");
		}
		modelAndView.addObject("employer", employer);
		return modelAndView;
	}

	@RequestMapping(value = "/connectEmployerCandidate")
	public String connectEmployerCandidate(@RequestParam("id") int id, Principal principal) {
		employerService.connectWithCandidate(candidateService.find(id),
				employerService.findByLogin(principal.getName()));
		return "redirect:candidate/" + id;
	}

	@RequestMapping(value = "/myCandidates")
	public ModelAndView myCandidates(Principal principal) {
		Employer employer = employerService.findByLogin(principal.getName());
		ModelAndView modelAndView = new ModelAndView("empOffice/myCandidates");
		modelAndView.addObject("candidates",
				candidateService.getRandomBestCandidates(employerService.findByLogin(principal.getName()), 3, 6));
		modelAndView.addObject("myCandidates", employer.getCandidates());
		return modelAndView;
	}
}
