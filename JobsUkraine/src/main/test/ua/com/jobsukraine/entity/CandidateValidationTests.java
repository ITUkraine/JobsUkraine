package ua.com.jobsukraine.entity;

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
	private static Candidate validCandidate;

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();

		validCandidate = new Candidate();
		validCandidate.setName("Володя");
		validCandidate.setLastName("Чорненький");
		validCandidate.setAddress("Lviv");
		validCandidate.setCityWhereLookingForWork("Lviv");
		validCandidate.setSex("male");
		validCandidate.setEducation("NULP");
		validCandidate.setDateOfBirth(new Date());
		validCandidate.setDateStartToWork(new Date());
		validCandidate.setEmail("chornenkyy@gmail.com");
		validCandidate.setMobileNumber("0936195692");
	}

	@Test
	public void isNameValid() {
		assertTrue(validator.validateProperty(validCandidate, "name").isEmpty());
		assertTrue(validator.validateProperty(validCandidate, "lastName").isEmpty());
	}

	@Test
	public void isPhoneValid() {
		assertTrue(validator.validateProperty(validCandidate, "mobileNumber").isEmpty());
	}

	@Test
	public void isEmailValid() {
		assertTrue(validator.validateProperty(validCandidate, "email").isEmpty());
	}

	@Test
	public void isSexValid() {
		assertTrue(validator.validateProperty(validCandidate, "sex").isEmpty());
	}

	@Test
	public void isAddressValid() {
		assertTrue(validator.validateProperty(validCandidate, "address").isEmpty());
		assertTrue(validator.validateProperty(validCandidate, "cityWhereLookingForWork").isEmpty());
	}

	@Test
	public void isDatesValid() {
		assertTrue(validator.validateProperty(validCandidate, "dateOfBirth").isEmpty());
		assertTrue(validator.validateProperty(validCandidate, "dateStartToWork").isEmpty());
	}

	@Test
	public void candidateIsValid() {
		Set<ConstraintViolation<Candidate>> violations = validator.validate(validCandidate);
		assertTrue(violations.isEmpty());
	}
}
