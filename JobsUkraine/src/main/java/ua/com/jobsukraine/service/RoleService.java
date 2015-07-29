package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Role;

public interface RoleService {
	Role add(Role role);
	void delete(Integer id);
	Role edit(Role role);
	List<Role> getAll();
	Role findByName(String name);
}
