package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Vacancy;
import ua.com.jobsukraine.repository.VacancyRepository;
import ua.com.jobsukraine.service.CategoryService;
import ua.com.jobsukraine.service.VacancyService;

@Service
@Transactional
public class VacancyServiceImpl implements VacancyService {

	@Autowired
	private VacancyRepository vr;
	@Autowired
	private CategoryService cs;

	@Override
	public Vacancy add(Vacancy obj) {
		obj.setCategory(cs.findByName(obj.getCategory().getName()));
		return vr.saveAndFlush(obj);
	}

	@Override
	public void delete(int id) {
		vr.delete(id);
	}

	@Override
	public Vacancy edit(Vacancy obj) {
		return vr.saveAndFlush(obj);
	}

	@Override
	public Vacancy find(int id) {
		return vr.findOne(id);
	}

	@Override
	public List<Vacancy> getAll() {
		return vr.findAll();
	}

}
