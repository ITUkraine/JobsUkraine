package ua.com.jobsukraine.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ua.com.jobsukraine.config.HSQLTestConfig;
import ua.com.jobsukraine.config.TestConfig;
import ua.com.jobsukraine.entity.LoginInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class LoginInfoServiceTest {

	@Autowired
	private LoginInfoService loginInfoService;
	@Autowired
	private RoleService roleService;
    
	private LoginInfo loginInfo;

	@Before
	public void init() {
		loginInfo = new LoginInfo();
		loginInfo.setLogin("login");
		loginInfo.setRole(roleService.findByName("ROLE_ADMIN"));
		loginInfo.setPassword("123123123");
		loginInfo.setConfirmPassword("123123123");
	}

	@Test
	public void isLoginInfoSaved() {
		LoginInfo addedLoginInfo = loginInfoService.save(loginInfo);
		assertNotNull(loginInfo.getId());

		assertEquals(loginInfo.getLogin(), addedLoginInfo.getLogin());

		LoginInfo addedSameLoginInfoOneMoreTime = loginInfoService.save(loginInfo);
		assertEquals(addedLoginInfo.getId(), addedSameLoginInfoOneMoreTime.getId());
	}

	@Test
	public void isLoginInfoFindedByLogin() {
		LoginInfo addedLoginInfo = loginInfoService.save(loginInfo);
		assertNotNull(addedLoginInfo.getId());

		assertEquals(addedLoginInfo, loginInfoService.findByLogin(addedLoginInfo.getLogin()));
	}

}
