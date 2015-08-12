package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.Role;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class RoleServiceTest {

	@Autowired
	private RoleService roleService;

	@Test
	public void isRoleAdded() {
		Role role = new Role("ROLE_ADMIN");
		assertNull(role.getId());

		Role addedRole = roleService.save(role);
		assertEquals(role.getName(), addedRole.getName());

		Role addedSameRoleOneMoreTime = roleService.save(role);
		assertEquals(addedRole.getId(), addedSameRoleOneMoreTime.getId());
	}

	@Test
	public void isAllRolesGetted() {
		Role roleOne = roleService.save(new Role("ROLE_ADMIN"));
		Role roleTwo = roleService.save(new Role("ROLE_CANDIDATE"));

		List<Role> roles = roleService.getAll();

		assertTrue(roles.contains(roleOne) && roles.contains(roleTwo));
	}

	@Test
	public void isRoleFindedByName() {
		Role addedRole = roleService.save(new Role("ROLE_ADMIN"));
		assertNotNull(addedRole.getId());

		assertEquals(addedRole, roleService.findByName(addedRole.getName()));
	}

}
