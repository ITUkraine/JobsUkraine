package ua.com.jobsukraine.service.impl;

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
	public Vacancy add(Vacancy obj) {
		obj.setCategory(categoryService.findByName(obj.getCategory().getName()));
		return vacancyRepository.saveAndFlush(obj);
	}

	@Override
	public void delete(int id) {
		vacancyRepository.delete(id);
	}

	@Override
	public Vacancy edit(Vacancy obj) {
		return vacancyRepository.saveAndFlush(obj);
	}

	@Override
	public Vacancy find(int id) {
		return vacancyRepository.findOne(id);
	}

	@Override
	public Vacancy add(Employer emp, Vacancy obj) {
		obj.setEmployer(emp);
		obj.setCategory(categoryService.findByName(obj.getCategory().getName()));
		return vacancyRepository.saveAndFlush(obj);
	}

}
