package ua.com.jobsukraine.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.Role;
import ua.com.jobsukraine.repository.RoleRepository;
import ua.com.jobsukraine.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository rr;
	
	@Override
	public Role add(Role role) {
		return rr.save(role);
	}

	@Override
	public void delete(Integer id) {
		rr.delete(id);
	}

	@Override
	public Role edit(Role role) {
		return rr.saveAndFlush(role);
	}

	@Override
	public List<Role> getAll() {
		return rr.findAll();
	}

	@Override
	public Role findByName(String name) {
		return rr.findByName(name);
	}

}
