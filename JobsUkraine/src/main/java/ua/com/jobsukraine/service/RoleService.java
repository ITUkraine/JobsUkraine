package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.Role;

public interface RoleService{
	
	Role save(Role role);
	
	Role findByName(String name);

	List<Role> getAll();
	
}
