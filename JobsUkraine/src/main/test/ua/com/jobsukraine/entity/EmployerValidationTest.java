package ua.com.jobsukraine.entity;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployerValidationTest {
	private static Validator validator;
	private static Employer validEmployer;

	@BeforeClass
	public static void init() {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		validator = vf.getValidator();

		validEmployer = new Employer();
		// @NotNull
		validEmployer.setAddress("Lviv"); 
		// @Email
		validEmployer.setEmail("roman@i.ua"); 
		// @Column(unique=true), @Size(min = 5, max = 12), @Pattern(regexp = "[0-9]+")
		validEmployer.setPhone("0934477994"); 
		//@Size(min = 0, max = 30)
		validEmployer.setWebsite("https://www.google.com.ua"); 
	}
	
	@Test
	public void isAddressValid() {
		assertTrue(validator.validateProperty(validEmployer, "address").isEmpty());
	}

	@Test
	public void isEmailValid() {
		assertTrue(validator.validateProperty(validEmployer, "email").isEmpty());
	}

	@Test
	public void isPhoneValid() {
		assertTrue(validator.validateProperty(validEmployer, "phone").isEmpty());
	}

	@Test
	public void isWebsiteValid() {
		assertTrue(validator.validateProperty(validEmployer, "website").isEmpty());
	}

}
