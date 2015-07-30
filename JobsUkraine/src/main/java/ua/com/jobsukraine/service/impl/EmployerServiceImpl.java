package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.repository.EmployerRepository;
import ua.com.jobsukraine.service.EmployerService;

@Service
@Transactional
public class EmployerServiceImpl  implements EmployerService{

	@Autowired
	private EmployerRepository ep;
	
	@Override
	public Employer add(Employer employer) {
		return ep.save(employer);
	}

	@Override
	public void delete(int id) {
		ep.delete(id);
	}

	@Override
	public Employer edit(Employer employer) {
		return ep.saveAndFlush(employer);
	}

	@Override
	public List<Employer> getAll() {
		return ep.findAll();
	}

	@Override
	public Employer find(int id) {
		return ep.findOne(id);
	}

}
