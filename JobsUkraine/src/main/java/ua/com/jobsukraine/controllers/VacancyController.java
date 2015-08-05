package ua.com.jobsukraine.controllers;

import java.security.Principal;

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
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.VacancyService;

@Controller
public class VacancyController {

	@Autowired
	private VacancyService vs;
	@Autowired
	private CategoryService cs;
	@Autowired
	private EmployerService es;

	@RequestMapping(value = "/empOffice/addVacancy")
	public String goAddVacancyPage(Model model, Principal principal) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("vacancies", es.getVacancies(principal.getName()));
		model.addAttribute("list", cs.getAll());
		model.addAttribute("category", new Category());

		return "empOffice/addVacancy";

	}

	@RequestMapping(value = "/empOffice/addVacancy", method = RequestMethod.POST)
	public String goAddVacancy(@ModelAttribute("vacancy") Vacancy vacancy, BindingResult bindingResult,
			Principal principal) {
		vs.add(es.findByLogin(principal.getName()), vacancy);
		return "redirect:/empOffice/addVacancy";

	}
}
