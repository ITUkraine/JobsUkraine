package ua.com.jobsukraine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Controller
@ComponentScan("ua.com.jobsukraine.service")
@SessionAttributes(types = Employer.class)
public class EmployerController {

	@Autowired
	private EmployerService employerService;
	@Autowired
	private LoginInfoService LoginInfoService;
	@Autowired
	private RoleService roleService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/regEmployer", method = RequestMethod.GET)
	public String addEmployerLogin(Model model) {

		model.addAttribute("empForm", new Employer());

		return "regemp/RegEmpOne";
	}

	@RequestMapping(value = "/addEmployerInfo", method = RequestMethod.POST)
	public String addEmployerInfo(Employer emp) {
		System.out.println(emp);
		return "regemp/RegEmpTwo";

	}

	@RequestMapping(value = "/addEmpCategory", method = RequestMethod.GET)
	public String addEmpCategory(Employer emp, Model model) {
		List<Category> listCat = categoryService.getAll();
		System.out.println(listCat);
		model.addAttribute("listCat", listCat);
		listCat.get(1);
/*		model.addAttribute("category", new Category());
*/		return "regemp/regEmpAddCategory";

	}

	@RequestMapping(value = "/regEmployerNew", method = RequestMethod.POST)
	public String register(Employer empForm, BindingResult result) {

		System.out.println(empForm);
		System.out.println(empForm.getInfo().toString());
		empForm.getInfo().setRole(roleService.findByName("employer"));
		LoginInfoService.add(empForm.getInfo());
		employerService.add(empForm);
		return "welcome";

	}

}
