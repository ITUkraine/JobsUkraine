package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertTrue;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginInfoTest {
	private static Validator validator;
	private static LoginInfo validLoginInfo;

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
		validLoginInfo = new LoginInfo();

		// @NotNull, @Pattern(regexp = "[a-zA-Z0-9]+"), @Size(min = 8, max = 20)
		validLoginInfo.setPassword("11223344");
		// must match with "password"
		validLoginInfo.setConfirmPassword("11223344");
		// @NotNull, @Column(unique = true), @Pattern(regexp = "[a-zA-Z0-9]+"),
		// @Size(min = 4, max = 20)
		validLoginInfo.setLogin("tryroman");
	}

	@Test
	public void isPasswordValid() {
		assertTrue(validator.validateProperty(validLoginInfo, "password").isEmpty());
	}

	@Test
	public void isConfirmPasswordValid() {
		assertTrue(validator.validateProperty(validLoginInfo, "confirmPassword").isEmpty());
	}

	@Test
	public void isLoginValid() {
		assertTrue(validator.validateProperty(validLoginInfo, "login").isEmpty());
	}
}
