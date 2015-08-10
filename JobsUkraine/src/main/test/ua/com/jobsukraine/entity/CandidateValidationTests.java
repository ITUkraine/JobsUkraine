package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CandidateValidationTests {

	private static Validator validator;
	private static Candidate candidate;
	private Set<ConstraintViolation<Candidate>> constraintViolations;

	private final static String NOT_NULL_MSG = "This field is mandatory";
	private final static String WRONG_EMAIL_MSG = "Wrong email format";
	private final static String WRONG_SEX_MSG = "Must match \"male\" or \"female\"";
	private final static String WRONG_PHONE_MSG = "Wrong phone format";

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();
	}

	@Before
	public void reinit() {
		candidate = new Candidate();
	}

	@Test
	public void isCityWhereLookingForWorkValid() {
		String fieldNameCityWhereLookingForWork = "cityWhereLookingForWork";

		// valid cityWhereLookingForWork
		candidate.setCityWhereLookingForWork("Ukraine, Lviv");
		assertTrue(validator.validateProperty(candidate, fieldNameCityWhereLookingForWork).isEmpty());

		// null
		candidate.setCityWhereLookingForWork(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameCityWhereLookingForWork);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isDateOfBirthValid() {
		String fieldNameDateOfBirth = "dateOfBirth";

		// valid dateOfBirth
		candidate.setDateOfBirth(new Date());
		assertTrue(validator.validateProperty(candidate, fieldNameDateOfBirth).isEmpty());

		// null
		candidate.setDateOfBirth(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameDateOfBirth);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isEmailVaild() {
		String fieldNameEmail = "email";

		// valid email
		candidate.setEmail("chornenkyy@gmail.com");
		assertTrue(validator.validateProperty(candidate, fieldNameEmail).isEmpty());

		candidate.setEmail("123-foggy@mail.com");
		assertTrue(validator.validateProperty(candidate, fieldNameEmail).isEmpty());

		// null
		candidate.setEmail(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameEmail);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// wrong email format
		candidate.setEmail("someWrongEmail");
		constraintViolations = validator.validateProperty(candidate, fieldNameEmail);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		candidate.setEmail("foggy@mail,com");
		constraintViolations = validator.validateProperty(candidate, fieldNameEmail);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		candidate.setEmail("@foggy@mail.com");
		constraintViolations = validator.validateProperty(candidate, fieldNameEmail);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isLastNameValid() {
		String fieldNameLastName = "lastName";

		// valid lastName
		candidate.setLastName("Chornenkiy");
		assertTrue(validator.validateProperty(candidate, fieldNameLastName).isEmpty());

		candidate.setLastName("Чорненький");
		assertTrue(validator.validateProperty(candidate, fieldNameLastName).isEmpty());

		candidate.setLastName("Abi-Dalai");
		assertTrue(validator.validateProperty(candidate, fieldNameLastName).isEmpty());

		candidate.setLastName("Алан-Хадіф");
		assertTrue(validator.validateProperty(candidate, fieldNameLastName).isEmpty());

		// null
		candidate.setLastName(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameLastName);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isNameValid() {
		String fieldNameName = "name";

		// valid name
		candidate.setName("Volodia");
		assertTrue(validator.validateProperty(candidate, fieldNameName).isEmpty());

		candidate.setName("Володя");
		assertTrue(validator.validateProperty(candidate, fieldNameName).isEmpty());

		// null
		candidate.setName(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameName);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isSexValid() {
		String fieldNameSex = "sex";

		// valid sex
		candidate.setSex("male");
		assertTrue(validator.validateProperty(candidate, fieldNameSex).isEmpty());

		candidate.setSex("female");
		assertTrue(validator.validateProperty(candidate, fieldNameSex).isEmpty());

		// not valid
		candidate.setSex("anotherSex");
		constraintViolations = validator.validateProperty(candidate, fieldNameSex);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_SEX_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// null
		candidate.setSex(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameSex);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isMobileNumberValid() {
		String fieldNameMobileNumber = "mobileNumber";

		// valid mobileNumber
		candidate.setMobileNumber("0936195692");
		assertTrue(validator.validateProperty(candidate, fieldNameMobileNumber).isEmpty());

		// wrong format
		candidate.setMobileNumber("aaaaaa");
		constraintViolations = validator.validateProperty(candidate, fieldNameMobileNumber);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_PHONE_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// null
		candidate.setMobileNumber(null);
		constraintViolations = validator.validateProperty(candidate, fieldNameMobileNumber);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}
}