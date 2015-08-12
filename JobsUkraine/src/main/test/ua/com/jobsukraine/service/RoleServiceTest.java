package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;

	@Test
	public void isRoleAdded() {
		Role role = new Role("ROLE_ADMIN");
		assertNull(role.getId());

		Role addedRole = roleService.save(role);
		assertNotNull(role.getId());
		assertEquals(role.getName(), addedRole.getName());

		Role addedSameRoleOneMoreTime = roleService.save(role);
		assertEquals(addedRole.getId(), addedSameRoleOneMoreTime.getId());
	}

	@Test
	public void isAllRolesGetted() {
		List<Role> addedRoles = new ArrayList<>();
		addedRoles.add(roleService.save(new Role("ROLE_ADMIN")));
		addedRoles.add(roleService.save(new Role("ROLE_CANDIDATE")));

		List<Role> roles = roleService.getAll();
		assertTrue(roles.size() == 2);

		assertTrue(addedRoles.containsAll(roles));
	}

	@Test
	public void isRoleFindedByName() {
		Role addedRole = roleService.save(new Role("ROLE_ADMIN"));
		assertNotNull(addedRole.getId());

		assertEquals(addedRole, roleService.findByName(addedRole.getName()));
	}

}
