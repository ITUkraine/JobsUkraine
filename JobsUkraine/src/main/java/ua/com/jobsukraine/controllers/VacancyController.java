package ua.com.jobsukraine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.VacancyService;

@Controller
public class VacancyController {

	@Autowired
	private VacancyService vs;
	@Autowired
	private CategoryService cs;

	@RequestMapping(value = "/addVacancy")
	public String goAddVacancyPage(Model model) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("list", cs.getAll());
		model.addAttribute("item", new Category());

		return "addVacancy";

	}

	@RequestMapping(value = "/addVacancy", method = RequestMethod.POST)
	public String goAddVacancy(@ModelAttribute("vacancy") Vacancy vacancy, BindingResult bindingResult) {
		vs.add(vacancy);
		//System.out.println(cs.findByName("Java"));
		return "home";

	}
}
