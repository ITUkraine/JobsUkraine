package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

		Role addedRole = roleService.add(role);
		assertNotNull(role.getId());
		assertEquals(role.getName(), addedRole.getName());

		Role addedSameRoleOneMoreTime = roleService.add(role);
		assertEquals(addedRole.getId(), addedSameRoleOneMoreTime.getId());
	}

}
 