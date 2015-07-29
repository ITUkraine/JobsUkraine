package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.repository.CandidateRepository;
import ua.com.jobsukraine.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository cr;
	
	@Override
	public Candidate add(Candidate candidate) {
		return cr.save(candidate);
	}

	@Override
	public void delete(int id) {
		cr.delete(id);
	}

	@Override
	public Candidate edit(Candidate candidate) {
		return cr.saveAndFlush(candidate);
	}

	@Override
	public List<Candidate> getAll() {
		return cr.findAll();
	}

}
