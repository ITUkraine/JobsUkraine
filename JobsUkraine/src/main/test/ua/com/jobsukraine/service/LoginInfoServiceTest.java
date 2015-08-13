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
import ua.com.jobsukraine.entity.LoginInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { HSQLTestConfig.class, TestConfig.class })
@Transactional
public class LoginInfoServiceTest {

	@Autowired
	private LoginInfoService loginInfoService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void isLoginInfoSaved() {
		try {
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 0);

			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setLogin("login");
			loginInfo.setPassword("123123123");
			loginInfo.setConfirmPassword("123123123");

			loginInfoService.save(loginInfo);
			Assert.assertTrue(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM logininfo", Integer.class) == 1);
		} finally {
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

	@Test
	public void isLoginInfoFindedByLogin() {
		try {
			String login = "employer";
			jdbcTemplate.execute("INSERT INTO logininfo VALUES (1, '" + login + "', 'password', null)");
			Assert.assertEquals(login, loginInfoService.findByLogin(login).getLogin());
		} finally {
			jdbcTemplate.execute("DELETE FROM logininfo");
		}
	}

}
