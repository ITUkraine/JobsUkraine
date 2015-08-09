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
	private CategoryService cs;
	@Autowired
	private EmployerService es;
	@Autowired
	private VacancyService vs;
	
	public VacancyController() {
	}
	
	public VacancyController(VacancyService vs, CategoryService cs, EmployerService es) {
		super();
		this.vs = vs;
		this.cs = cs;
		this.es = es;
	}

	@RequestMapping(value = "/vacancy/delete")
	public String deleteVacancy(@RequestParam("id") int id) {
		vs.delete(id);
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy", method = RequestMethod.POST)
	public String goAddVacancy(@ModelAttribute("vacancy") Vacancy vacancy, BindingResult bindingResult,
			Principal principal) {
		vs.add(es.findByLogin(principal.getName()), vacancy);
		return "redirect:/empOffice/addVacancy";
	}

	@RequestMapping(value = "/empOffice/addVacancy")
	public String goAddVacancyPage(Model model, Principal principal) {
		model.addAttribute("vacancy", new Vacancy());
		model.addAttribute("vacancies", es.getVacancies(principal.getName()));
		model.addAttribute("list", cs.getAll());
		model.addAttribute("category", new Category());

		return "empOffice/addVacancy";

	}

	@RequestMapping(value = "/vacancy/{id}")
	public ModelAndView showVacancyInfoPage(@PathVariable(value = "id") int id, Principal principal) {
		ModelAndView mav = new ModelAndView("vacancy");
		Vacancy vacancy = vs.find(id);
		// check if entered same employer to enable buttons for edit/delete
		mav.addObject("sameEmployer", vacancy.getEmployer().getInfo().getLogin().equals(principal.getName()));

		mav.addObject("vacancy", vacancy);
		return mav;
	}

}
