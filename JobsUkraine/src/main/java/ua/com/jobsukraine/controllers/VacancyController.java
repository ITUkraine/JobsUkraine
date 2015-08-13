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
import ua.com.jobsukraine.exceptions.CustomMessageException;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.VacancyService;

@Controller
public class VacancyController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private VacancyService vacancyService;
	@Autowired
	private LoginInfoService loginInfoService;

	@RequestMapping(value = "/vacancy/delete")
	public String deleteVacancy(@RequestParam("id") int id, Principal principal) {
		vacancyService.delete(id);
		if (loginInfoService.findByLogin(principal.getName()).getRole().getName().equals("ROLE_ADMIN")) {
			return "redirect:/vacancies";
		}
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy", method = RequestMethod.POST)
	public String goAddVacancy(@ModelAttribute("vacancy") Vacancy vacancy, BindingResult bindingResult,
			Principal principal) {
		vacancyService.save(employerService.findByLogin(principal.getName()), vacancy);
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy")
	public String goAddVacancyPage(Model model, Principal principal) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("vacancies", employerService.getVacancies(employerService.findByLogin(principal.getName())));
		model.addAttribute("list", categoryService.getAll());
		model.addAttribute("category", new Category());

		return "empOffice/addVacancy";

	}

	@RequestMapping(value = "/vacancy/{id}")
	public ModelAndView showVacancyInfoPage(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView modelAndView = new ModelAndView("vacancy");
		Vacancy vacancy = vacancyService.find(id);
		if (vacancy == null) {
			throw new CustomMessageException("No vacancy founded");
		}
		modelAndView.addObject("vacancy", vacancy);
		return modelAndView;
	}

}
