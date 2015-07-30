package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.Role;

public interface RoleService extends DefaultService<Role> {
	
	Role findByName(String name);

}
