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

	final VacancyService vacancyService = mock(VacancyService.class);
	final BindingResult bindingResult = mock(BindingResult.class);
	final CategoryService categoryService = mock(CategoryService.class);
	final EmployerService employerService=mock(EmployerService.class);
	Vacancy vacancyCorrect = new Vacancy();
	final Vacancy vacancy = new Vacancy();
	VacancyController vacancyController;
	final Principal principal=mock(Principal.class);

	@Before
	public void initVacancyCorrect() {
		vacancyController = new VacancyController(vacancyService, categoryService, employerService);
		vacancyCorrect.setDescription("1000");
		vacancyCorrect.setName("IT");
		vacancyCorrect.setSalary(1000);
	}
	
	@Test
	public void testGoAddVacancyPage() throws Exception {
		Model model = mock(Model.class);
		String result = vacancyController.goAddVacancyPage(model, principal);
		assertEquals(result, "empOffice/addVacancy");
	}
	
	@Test 
	public void testGoAddVacancy ()	{
		String result = vacancyController.goAddVacancy(vacancyCorrect, bindingResult, principal);
		assertEquals(result, "redirect:/empOffice/addVacancy");
	}

	@Test
	public void testDeleteVacancy	()	{
		String result = vacancyController.deleteVacancy(1);
		Mockito.verify(vacancyService).delete(1);
		assertEquals(result, "redirect:/empOffice/addVacancy");
	}
}
