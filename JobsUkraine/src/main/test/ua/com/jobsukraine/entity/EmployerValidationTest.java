package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployerValidationTest {

	private static Validator validator;
	private static Employer employer;
	private Set<ConstraintViolation<Employer>> constraintViolations;

	private final static String NOT_NULL_MSG = "This field is mandatory";
	private final static String WRONG_EMAIL_MSG = "Wrong email format";
	private final static String WRONG_PHONE_MSG = "Wrong phone format";

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@Before
	public void reinit() {
		employer = new Employer();
	}

	@Test
	public void isAddressValid() {
		// valid address
		employer.setAddress("Ukraine, Lviv");
		assertTrue(validator.validateProperty(employer, "address").isEmpty());

		// null
		employer.setAddress(null);
		constraintViolations = validator.validateProperty(employer, "address");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isEmailVaild() {
		// valid email
		employer.setEmail("chornenkyy@gmail.com");
		assertTrue(validator.validateProperty(employer, "email").isEmpty());

		employer.setEmail("123-foggy@mail.com");
		assertTrue(validator.validateProperty(employer, "email").isEmpty());

		// null
		employer.setEmail(null);
		constraintViolations = validator.validateProperty(employer, "email");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// wrong email format
		employer.setEmail("someWrongEmail");
		constraintViolations = validator.validateProperty(employer, "email");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		employer.setEmail("foggy@mail,com");
		constraintViolations = validator.validateProperty(employer, "email");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		employer.setEmail("@foggy@mail.com");
		constraintViolations = validator.validateProperty(employer, "email");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

	}

	@Test
	public void isDescriptionValid() {
		// valid description
		employer.setDescription("some great description");
		assertTrue(validator.validateProperty(employer, "description").isEmpty());

		// null
		employer.setDescription(null);
		constraintViolations = validator.validateProperty(employer, "address");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isPhoneValid() {
		// valid phone -- pattern: ^[0-9\\-\\(\\)]*$
		employer.setPhone("0936195692");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("093-61-95-692");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("093-619-56-92");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("2510255");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("251-02-55");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("25-10-255");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		employer.setPhone("(032)2510255");
		assertTrue(validator.validateProperty(employer, "phone").isEmpty());

		// wrong format
		employer.setPhone("aaaaaa");
		constraintViolations = validator.validateProperty(employer, "phone");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_PHONE_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// null
		employer.setPhone(null);
		constraintViolations = validator.validateProperty(employer, "phone");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isNameValid() {
		// valid name
		employer.setName("JobsUkraine");
		assertTrue(validator.validateProperty(employer, "name").isEmpty());

		employer.setName("JobsUkraine Inc.");
		assertTrue(validator.validateProperty(employer, "name").isEmpty());

		employer.setName("JobsUkraine 032");
		assertTrue(validator.validateProperty(employer, "name").isEmpty());

		// null
		employer.setName(null);
		constraintViolations = validator.validateProperty(employer, "name");
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

}
