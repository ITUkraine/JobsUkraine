package ua.com.jobsukraine.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void isRoleAdded() {
		try {
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROLE", Integer.class) == 0);

			Role role = new Role("ROLE_ADMIN");
			roleService.save(role);
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROLE", Integer.class) == 1);

			roleService.save(role);
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROLE", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM ROLE");
		}
	}

	@Test
	public void isAllRolesGetted() {
		try {
			jdbcTemplate.execute("INSERT INTO role VALUES (1, 'ROLE_ADMIN'),(2, 'ROLE_CANDIDATE')");
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM ROLE", Integer.class) == 2);

			Assert.assertTrue(roleService.getAll().size() == 2);
		} finally {
			jdbcTemplate.execute("DELETE FROM ROLE");
		}
	}

	@Test
	public void isRoleFindedByName() {
		try {
			String roleName = "ROLE_ADMIN";
			jdbcTemplate.execute("INSERT INTO role VALUES (1, '" + roleName + "')");
			Assert.assertEquals(roleName, roleService.findByName(roleName).getName());
		} finally {
			jdbcTemplate.execute("DELETE FROM ROLE");
		}
	}

}
