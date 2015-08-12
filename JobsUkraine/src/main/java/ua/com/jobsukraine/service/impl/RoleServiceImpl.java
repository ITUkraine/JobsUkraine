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
	private RoleRepository roleRepository;

	@Override
	public Role save(Role role) {
		if (findByName(role.getName()) == null) {
			return roleRepository.save(role);
		} else {
			return findByName(role.getName());
		}
	}

	@Override
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

}
