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
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
@SessionAttributes(types=Candidate.class)
public class CandidateController {
	
	@Autowired
	private CandidateService cs;
	@Autowired
	private LoginInfoService lis;
	@Autowired
	private RoleService rs;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Map<String, Object> model) {
		model.put("candidate", new Candidate());
		return "regcandidate/RegCandidateOne";
	}
	
	@RequestMapping(value="/candidateOffice", method=RequestMethod.POST)
	public String goLogin(@ModelAttribute("loginForm") LoginInfo loginInfo, 
			Map<String,Object> model){
		model.put("candidate", cs.fingByLogin(loginInfo.getLogin()));
		System.out.println(loginInfo);
		return "candidateOffice";
	}
	
	@RequestMapping(value="/addCandidateInfo", method = RequestMethod.POST )
    public String addCandidateInfo(Candidate candidate){
		System.out.println(candidate);
		return "regcandidate/RegCandidateTwo";
		
	}
	
	@RequestMapping(value="/addCandidateCategory", method = RequestMethod.POST)
    public String addCandidateCategory(Candidate candidate, Model model){
		List<Category> listCat = categoryService.getAll();
		model.addAttribute("category", listCat);
		return "regcandidate/regCandidateAddCategory";
		
	}
	
	
	@RequestMapping(value = "/regCandidateNew", method = RequestMethod.POST)
	public String register(Candidate candidate, BindingResult result) {

		System.out.println(candidate);
		System.out.println(candidate.getInfo().toString());
		candidate.getInfo().setRole(rs.findByName("candidate"));
		lis.add(candidate.getInfo());
		cs.add(candidate);
		return "welcome";

	}
}
