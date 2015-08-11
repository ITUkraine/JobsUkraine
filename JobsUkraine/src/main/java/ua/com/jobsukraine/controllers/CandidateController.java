package ua.com.jobsukraine.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.Collections;
import java.util.List;

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

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Feedback;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.FeedbackService;
import ua.com.jobsukraine.service.SecurityService;

@Controller
@ComponentScan(basePackages = { "ua.com.jobsukraine.service.impl", "ua.com.jobsukraine.security.handler",
		"ua.com.jobsukraine.security" })
@SessionAttributes(types = { Candidate.class, LoginInfo.class })
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private FeedbackService feedbackService;

	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Model model) {
		model.addAttribute("infoForm", new LoginInfo());
		return "regcandidate/RegCandidateOne";
	}

	

	@RequestMapping(value = "/addCandidateInfo", method = RequestMethod.POST)
	public String addCandidateInfo(@Valid @ModelAttribute("infoForm") LoginInfo loginInfo, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "regcandidate/RegCandidateOne";
		} else {
			model.addAttribute("candidate", new Candidate());
			return "regcandidate/RegCandidateTwo";
		}

	}

	@RequestMapping(value = "/addCandidateInfo2", method = RequestMethod.POST)
	public String addCandidateInfo2(@Valid @ModelAttribute("candidate") Candidate candidate,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "regcandidate/RegCandidateTwo";
		} else {
			return "regcandidate/RegCandidateThree";
		}

	}
	@RequestMapping(value = "/addCandidateCategory", method = RequestMethod.POST)
	public String addCandidateCategory(@ModelAttribute("candidate") Candidate candidate, Model model) {
		model.addAttribute("listCat", categoryService.getAll());
		return "regcandidate/regCandidateAddCategory";

	}
	@RequestMapping(value = "regCandidateNew", method = RequestMethod.POST)
	public String doAutoLogin(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("infoForm") LoginInfo loginInfo, @ModelAttribute("candidate") Candidate candidate, Model model)
					throws IOException {
		if (candidate.getCategories()==null) {
			model.addAttribute("msg", "Please, select at least one category");
			model.addAttribute("listCat", categoryService.getAll());
			return "regcandidate/regCandidateAddCategory";
		} else {
		String password = loginInfo.getPassword();
		securityService.encodePassword(loginInfo);
		candidateService.register(candidate, loginInfo);
		securityService.autoLoginAfterRegistration(request, response, loginInfo.getLogin(), password);
		return null;}
	}

	@RequestMapping(value = "/candidateOffice", method = RequestMethod.GET)
	public String goLogin(Principal principal, Model model) {
		Candidate candidate = candidateService.findByLogin(principal.getName());
		model.addAttribute("candidate", candidate);
		Collections.sort(candidate.getFeedbacks());
		model.addAttribute("vacancies", candidateService.getAvailableVacancies(candidate));
		return "candidateOffice/profile";
	}

	@RequestMapping(value = "/candidate/{id}")
	public ModelAndView showCandidateInfoPage(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("candidate");
		Candidate candidate = candidateService.find(id);
		modelAndView.addObject("candidate", candidate);
		Collections.sort(candidate.getFeedbacks());
		modelAndView.addObject("feedback", new Feedback());
		modelAndView.addObject("list", categoryService.getAll());
		return modelAndView;
	}
	
	@RequestMapping(value = "/candidate/addFeedBack", method = RequestMethod.POST)
	public String addFeedback(@ModelAttribute("feedback") Feedback feedback,
			@ModelAttribute("candidate") Candidate candidate, Principal principal) {
		feedbackService.add(candidate, feedback, principal);
		return "redirect:/candidate/"+candidate.getId();
	}

}
