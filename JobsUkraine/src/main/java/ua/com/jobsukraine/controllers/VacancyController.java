package ua.com.jobsukraine.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.com.jobsukraine.entity.Category;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.VacancyService;

@Controller
public class VacancyController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EmployerService employerService;

	private Vacancy vacancy;
	@Autowired
	private VacancyService vacancyService;


	public VacancyController() {

	}

	public VacancyController(VacancyService vacancyService, CategoryService categoryService,
			EmployerService employerService, Vacancy vacancy) {
		this.vacancyService = vacancyService;
		this.categoryService = categoryService;
		this.employerService = employerService;
		this.vacancy = vacancy;

	}

	@RequestMapping(value = "/vacancy/delete")
	public String deleteVacancy(@RequestParam("id") int id) {
		vacancyService.delete(id);
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy", method = RequestMethod.POST)
	public String goAddVacancy(@ModelAttribute("vacancy") Vacancy vacancy, BindingResult bindingResult,
			Principal principal) {
		vacancyService.add(employerService.findByLogin(principal.getName()), vacancy);
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy")
	public String goAddVacancyPage(Model model, Principal principal) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("vacancies", employerService.getVacancies(principal.getName()));
		model.addAttribute("list", categoryService.getAll());
		model.addAttribute("category", new Category());

		return "empOffice/addVacancy";

	}

	@RequestMapping(value = "/vacancy/{id}")
	public ModelAndView showVacancyInfoPage(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("vacancy");
		vacancy = vacancyService.find(id);
		modelAndView.addObject("vacancy", vacancy);
		return modelAndView;
	}

}
