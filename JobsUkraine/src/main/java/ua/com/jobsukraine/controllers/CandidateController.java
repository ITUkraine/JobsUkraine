package ua.com.jobsukraine.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
public class CandidateController {
	
	@Autowired
	private CandidateService cs;
	@Autowired
	private LoginInfoService lis;
	@Autowired
	private RoleService rs;
	
	@RequestMapping(value = "/regCandidate", method = RequestMethod.GET)
	public String addCandidate(Map<String, Object> model) {
		model.put("candidate", new Candidate());
		return "regCandidate";
	}

	@RequestMapping(value = "/regCandidate", method = RequestMethod.POST)
	public String register(@ModelAttribute("candidate") Candidate candidate, BindingResult result) {
		candidate.getInfo().setRole(rs.findByName("candidate"));
		lis.add(candidate.getInfo());
		cs.add(candidate);
		return "welcome";
	}
	
	@RequestMapping(value="/candidateOffice", method=RequestMethod.POST)
	public String goLogin(@ModelAttribute("loginForm") LoginInfo loginInfo, 
			Map<String,Object> model){
		model.put("candidate", cs.fingByLogin(loginInfo.getLogin()));
		System.out.println(loginInfo);
		return "candidateOffice";
	}
	
}
