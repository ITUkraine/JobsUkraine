package ua.com.jobsukraine.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.security.Principal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import ua.com.jobsukraine.controllers.VacancyController;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.EmployerService;
import ua.com.jobsukraine.service.VacancyService;

@RunWith(JUnit4.class)
public class VacancyControllerTest {

	final private VacancyService vacancyService = mock(VacancyService.class);
	final private BindingResult bindingResult = mock(BindingResult.class);
	final private CategoryService categoryService = mock(CategoryService.class);
	final private EmployerService employerService = mock(EmployerService.class);
	final private Vacancy vacancy = new Vacancy();
	private VacancyController vacancyController;
	private Principal principal = mock(Principal.class);

	@Before
	public void initVacancyCorrect() {
		vacancyController = new VacancyController(vacancyService, categoryService, employerService, vacancy);
		principal = mock(Principal.class);
	}

	@Test
	public void testGoAddVacancyPage() throws Exception {
		Model model = mock(Model.class);
		String result = vacancyController.goAddVacancyPage(model, principal);
		Mockito.verify(model).addAttribute("vacancies", employerService.getVacancies(principal.getName()));
		Mockito.verify(model).addAttribute("list", categoryService.getAll());
		assertEquals(result, "empOffice/addVacancy");
	}

	@Test
	public void testGoAddVacancy() {
		String result = vacancyController.goAddVacancy(vacancy, bindingResult, principal);
		Mockito.verify(vacancyService).add(employerService.findByLogin(principal.getName()), vacancy);
		assertEquals(result, "redirect:/empOffice/addVacancy");
	}

	@Test
	public void testDeleteVacancy() {
		String result = vacancyController.deleteVacancy(1, principal);
		Mockito.verify(vacancyService).delete(1);
		assertEquals(result, "redirect:/empOffice/addVacancy");
	}
	
	
	
}
