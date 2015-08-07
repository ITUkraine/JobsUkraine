package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CandidateValidationTests {

	private static Validator validator;
	private static Candidate candidate;
	private Set<ConstraintViolation<Candidate>> constraintViolations;

	private final static String NOT_NULL_MSG = "This field is mandatory";
	private final static String WRONG_EMAIL_MSG = "Wrong email format";
	private final static String WRONG_SEX_MSG = "Must match \"male\" or \"female\"";

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();

		candidate = new Candidate();
	}

	@Test
	public void isAddressValid() {
		String fieldName_address = "address";

		// valid address
		candidate.setAddress("Ukraine, Lviv");
		assertTrue(validator.validateProperty(candidate, fieldName_address).isEmpty());

		// null
		candidate.setAddress(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_address);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isCityWhereLookingForWorkValid() {
		String fieldName_cityWhereLookingForWork = "cityWhereLookingForWork";

		// valid cityWhereLookingForWork
		candidate.setCityWhereLookingForWork("Ukraine, Lviv");
		assertTrue(validator.validateProperty(candidate, fieldName_cityWhereLookingForWork).isEmpty());

		// null
		candidate.setCityWhereLookingForWork(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_cityWhereLookingForWork);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isDateOfBirthValid() {
		String fieldName_dateOfBirth = "dateOfBirth";

		// valid dateOfBirth
		candidate.setDateOfBirth(new Date());
		assertTrue(validator.validateProperty(candidate, fieldName_dateOfBirth).isEmpty());

		// null
		candidate.setDateOfBirth(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_dateOfBirth);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isEmailVaild() {
		String fieldName_email = "email";

		// valid email
		candidate.setEmail("chornenkyy@gmail.com");
		assertTrue(validator.validateProperty(candidate, fieldName_email).isEmpty());

		candidate.setEmail("123-foggy@mail.com");
		assertTrue(validator.validateProperty(candidate, fieldName_email).isEmpty());

		// null
		candidate.setEmail(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_email);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// wrong email format
		candidate.setEmail("someWrongEmail");
		constraintViolations = validator.validateProperty(candidate, fieldName_email);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		candidate.setEmail("foggy@mail,com");
		constraintViolations = validator.validateProperty(candidate, fieldName_email);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));

		candidate.setEmail("@foggy@mail.com");
		constraintViolations = validator.validateProperty(candidate, fieldName_email);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_EMAIL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isLastNameValid() {
		String fieldName_lastName = "lastName";

		// valid lastName
		candidate.setLastName("Chornenkiy");
		assertTrue(validator.validateProperty(candidate, fieldName_lastName).isEmpty());

		candidate.setLastName("Чорненький");
		assertTrue(validator.validateProperty(candidate, fieldName_lastName).isEmpty());

		candidate.setLastName("Abi-Dalai");
		assertTrue(validator.validateProperty(candidate, fieldName_lastName).isEmpty());

		candidate.setLastName("Алан-Хадіф");
		assertTrue(validator.validateProperty(candidate, fieldName_lastName).isEmpty());

		// null
		candidate.setLastName(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_lastName);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isNameValid() {
		String fieldName_name = "name";

		// valid name
		candidate.setName("Volodia");
		assertTrue(validator.validateProperty(candidate, fieldName_name).isEmpty());

		candidate.setName("Володя");
		assertTrue(validator.validateProperty(candidate, fieldName_name).isEmpty());

		// null
		candidate.setName(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_name);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isSexValid() {
		String fieldName_sex = "sex";

		// valid sex
		candidate.setSex("male");
		assertTrue(validator.validateProperty(candidate, fieldName_sex).isEmpty());

		candidate.setSex("female");
		assertTrue(validator.validateProperty(candidate, fieldName_sex).isEmpty());

		// not valid
		candidate.setSex("anotherSex");
		constraintViolations = validator.validateProperty(candidate, fieldName_sex);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(WRONG_SEX_MSG.equals(constraintViolations.iterator().next().getMessage()));

		// null
		candidate.setSex(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_sex);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}

	@Test
	public void isMobileNumberValid() {
		String fieldName_mobileNumber = "mobileNumber";

		// valid mobileNumber
		candidate.setMobileNumber("0936195692");
		assertTrue(validator.validateProperty(candidate, fieldName_mobileNumber).isEmpty());

		// null
		candidate.setMobileNumber(null);
		constraintViolations = validator.validateProperty(candidate, fieldName_mobileNumber);
		assertFalse(constraintViolations.isEmpty());
		assertTrue(NOT_NULL_MSG.equals(constraintViolations.iterator().next().getMessage()));
	}
}