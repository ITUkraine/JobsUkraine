package ua.com.jobsukraine.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.repository.CandidateRepository;
import ua.com.jobsukraine.service.CandidateService;
import ua.com.jobsukraine.service.LoginInfoService;
import ua.com.jobsukraine.service.RoleService;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository cr;
	@Autowired
	private LoginInfoService lis;
	@Autowired
	private RoleService rs;
	
	@Override
	public Candidate add(Candidate candidate) {
		candidate.getInfo().setRole(rs.findByName("candidate"));
		lis.add(candidate.getInfo());
		try {
			candidate.setDateOfBirth((new SimpleDateFormat("dd/MM/yyyy").parse(candidate.getDateOfBirthInString()).getTime()));
			candidate.setDateStartToWork((new SimpleDateFormat("dd/MM/yyyy").parse(candidate.getDateStartToWorkInString()).getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	@Override
	public Candidate find(int id) {
		return cr.findOne(id);
	}

	@Override
	public Candidate findByName(String name) {
		return findByName(name);
	}

	@Override
	public Candidate findByLogin(String login) {
		return cr.findByLogin(login);
	}

	
}
