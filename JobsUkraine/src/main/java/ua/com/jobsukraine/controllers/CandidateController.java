package ua.com.jobsukraine.controllers;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
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
import ua.com.jobsukraine.service.SecurityService;

@Controller
@ComponentScan(basePackages = { "ua.com.jobsukraine.service.impl", "ua.com.jobsukraine.security.handler",
		"ua.com.jobsukraine.security" })
@SessionAttributes(types = {Candidate.class, LoginInfo.class})
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SecurityService securityService;
	
	final static Logger logger = Logger.getLogger(CandidateController.class);
	
	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Model model) {
		model.addAttribute("infoForm", new LoginInfo());
		return "regcandidate/RegCandidateOne";
	}


	@RequestMapping(value = "/addCandidateInfo", method = RequestMethod.POST)
	public String addCandidateInfo(@Valid @ModelAttribute("infoForm") LoginInfo info,BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "regcandidate/RegCandidateOne";
		} else {
			model.addAttribute("candidate", new Candidate());
			return "regcandidate/RegCandidateTwo";
		}

	}

	@RequestMapping(value = "/addCandidateInfo2", method = RequestMethod.POST)
	public String addCandidateInfo2(@Valid @ModelAttribute("candidate") Candidate candidate,BindingResult result ) {
		if (result.hasErrors()) {
			return "regcandidate/RegCandidateTwo";
		} else {
			return "regcandidate/RegCandidateThree";
		}

	}

	@RequestMapping(value = "/addCandidateCategory", method = RequestMethod.POST)
	public String addCandidateCategory(@ModelAttribute("candidate") Candidate candidate, Model model) {
		List<Category> listCat = categoryService.getAll();
		model.addAttribute("listCat", listCat);
		model.addAttribute("category", new Category());
		return "regcandidate/regCandidateAddCategory";

	}

	@RequestMapping(value = "regCandidateNew", method = RequestMethod.POST)
	public void doAutoLogin(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("infoForm") LoginInfo info,
			@ModelAttribute("candidate") Candidate candidate) throws IOException {
		String password = info.getPassword();
		securityService.encodePassword(info);
		candidateService.register(candidate, info);
		securityService.autoLoginAfterRegistration(request, response, candidate.getInfo().getLogin(), password);
	}
	
	@RequestMapping(value = "/candidateOffice", method = RequestMethod.GET)
	public String goLogin(Principal principal, Model model) {
		String login = principal.getName();
		model.addAttribute("candidate", candidateService.findByLogin(login));
		model.addAttribute("vacancies", candidateService.getAvailableVacancies(login));
		model.addAttribute("feedbacks", candidateService.getFeedbacks(candidateService.findByLogin(login).getId()));
		return "candidateOffice";
	}

	@RequestMapping(value = "/candidate/{id}")
	public ModelAndView showCandidateInfoPage(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("candidate");
		modelAndView.addObject("candidate", candidateService.find(id));
		System.out.println(candidateService.find(id));
		modelAndView.addObject("feedback", new Feedback());
		modelAndView.addObject("list", categoryService.getAll());
		System.out.println(candidateService.find(id));
		modelAndView.addObject("feedbacks", candidateService.getFeedbacks(id));
		System.out.println(candidateService.find(id));
		return modelAndView;
	}

}
