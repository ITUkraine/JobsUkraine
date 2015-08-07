package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class LoginInfoTest {
	private static Validator validator;
	private static LoginInfo loginInfo;
	private Set<ConstraintViolation<LoginInfo>> constraintViolations;

	private final static String NOT_NULL_MSG = "This field is mandatory";
	private final static String WRONG_LOGIN_MSG = "Wrong login format";
	private final static String WRONG_PASSWORD_LENGTH_MSG = "Password too short";
	private final static String WRONG_LOGIN_LENGTH_MSG = "Length must be from 4 to 20";

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();

		loginInfo = new LoginInfo();
	}

	@Test
	public void isPasswordValid() {
		String fieldName_password = "password";

		// valid confirmPassword
		loginInfo.setPassword("qwerty123");
		assertTrue(validator.validateProperty(loginInfo, fieldName_password).isEmpty());

		// null
		loginInfo.setPassword(null);
		constraintViolations = validator.validateProperty(loginInfo, fieldName_password);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
		
		//wrong format
		loginInfo.setPassword("qwer"); // from 6
		constraintViolations = validator.validateProperty(loginInfo, fieldName_password);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_PASSWORD_LENGTH_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isConfirmPasswordValid() {
		String fieldName_confirmPassword = "confirmPassword";

		// valid confirmPassword
		loginInfo.setConfirmPassword("qwerty123");
		assertTrue(validator.validateProperty(loginInfo, fieldName_confirmPassword).isEmpty());

		// null
		loginInfo.setConfirmPassword(null);
		constraintViolations = validator.validateProperty(loginInfo, fieldName_confirmPassword);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
		
		//wrong format
		loginInfo.setConfirmPassword("qwer"); // from 6
		constraintViolations = validator.validateProperty(loginInfo, fieldName_confirmPassword);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_PASSWORD_LENGTH_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isLoginValid() {
		String fieldName_login = "login";

		// valid login
		loginInfo.setLogin("temnoi123");
		assertTrue(validator.validateProperty(loginInfo, fieldName_login).isEmpty());

		// null
		loginInfo.setLogin(null);
		constraintViolations = validator.validateProperty(loginInfo, fieldName_login);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// wrong login format
		loginInfo.setLogin("кирилицюНеМожна"); // [a-zA-Z0-9]+
		constraintViolations = validator.validateProperty(loginInfo, fieldName_login);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_LOGIN_MSG.equals(constraintViolations.iterator().next().getMessage()));
		
		loginInfo.setLogin("Cant_use_underscores"); // [a-zA-Z0-9]+
		constraintViolations = validator.validateProperty(loginInfo, fieldName_login);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_LOGIN_MSG.equals(constraintViolations.iterator().next().getMessage()));
		
		loginInfo.setLogin("tes"); // from 4 to 20
		constraintViolations = validator.validateProperty(loginInfo, fieldName_login);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_LOGIN_LENGTH_MSG.equals(constraintViolations.iterator().next().getMessage()));
		
		loginInfo.setLogin("123456789012345678901"); // from 4 to 20
		constraintViolations = validator.validateProperty(loginInfo, fieldName_login);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_LOGIN_LENGTH_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}
}
