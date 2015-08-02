package ua.com.jobsukraine.controllers;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
@SessionAttributes(types = { Employer.class })
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	

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
	public String addCategory(@ModelAttribute("empForm") Employer emp, Model model) {
		ArrayList<Category> listCat = (ArrayList<Category>) categoryService.getAll();
		model.addAttribute("listCat", listCat);
		return "regemp/regEmpAddCategory";
	}

	@RequestMapping(value = "/regEmployerNew", method = RequestMethod.POST)
	public String register(@ModelAttribute("empForm") Employer emp, BindingResult result) {

		employerService.add(emp);

		return "welcome";

	}
	
	@RequestMapping(value = "/employerOffice", method = RequestMethod.POST)
	public String goLogin(@ModelAttribute("loginForm") LoginInfo loginInfo, Map<String, Object> model) {
//		model.put("candidate", cs.findByLogin(loginInfo.getLogin()));
//		model.put("vacancies", cs.getAvailableVacancies(loginInfo.getLogin()));
		return "employerOffice";
	}

}
