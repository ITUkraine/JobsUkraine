package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.VacancyRepository;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.VacancyService;

@Service
@Transactional
public class VacancyServiceImpl implements VacancyService {

	@Autowired
	private VacancyRepository vacancyRepository;
	@Autowired
	private CategoryService categoryService;

	@Override
	public Vacancy save(Employer employer, Vacancy vacancy) {
		vacancy.setEmployer(employer);
		vacancy.setCategory(categoryService.findByName(vacancy.getCategory().getName()));
		return vacancyRepository.saveAndFlush(vacancy);
	}

	@Override
	public Vacancy find(int id) {
		return vacancyRepository.findOne(id);
	}

	@Override
	public void delete(int id) {
		vacancyRepository.delete(id);
	}

	@Override
	public List<Vacancy> getAll() {
		return vacancyRepository.findAll();
	}

}
