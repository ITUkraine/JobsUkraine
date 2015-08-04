package ua.com.jobsukraine.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
@SessionAttributes(types = Candidate.class)
public class CandidateController {

	@Autowired
	private CandidateService cs;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Model model) {
		model.addAttribute("candidate", new Candidate());
		return "regcandidate/RegCandidateOne";
	}

	@RequestMapping(value = "/candidateOffice", method = RequestMethod.GET)
	public String goLogin(@ModelAttribute("loginForm") LoginInfo loginInfo, Map<String, Object> model) {
		model.put("candidate", cs.findByLogin(loginInfo.getLogin()));
		model.put("vacancies", cs.getAvailableVacancies(loginInfo.getLogin()));
		return "candidateOffice";
	}

	@RequestMapping(value = "/addCandidateInfo", method = RequestMethod.POST)
	public String addCandidateInfo(@ModelAttribute("candidate") Candidate candidate) {
		return "regcandidate/RegCandidateTwo";

	}

	@RequestMapping(value = "/addCandidateInfo2", method = RequestMethod.POST)
	public String addCandidateInfo2(@ModelAttribute("candidate") Candidate candidate) {
		return "regcandidate/RegCandidateThree";

	}

	@RequestMapping(value = "/addCandidateCategory", method = RequestMethod.POST)
	public String addCandidateCategory(@ModelAttribute("candidate") Candidate candidate, Model model) {
		List<Category> listCat = categoryService.getAll();
		model.addAttribute("listCat", listCat);
		model.addAttribute("category", new Category());
		return "regcandidate/regCandidateAddCategory";

	}

	@RequestMapping(value = "/regCandidateNew", method = RequestMethod.POST)
	public String register(@ModelAttribute("candidate") Candidate candidate, BindingResult result) {
		cs.add(candidate);
		return "welcome";

	}
}
