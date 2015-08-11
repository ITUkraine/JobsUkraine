package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.entity.Employer;
import ua.com.jobsukraine.repository.EmployerRepository;

public class UniqueEmployerValidator  implements
ConstraintValidator<UniqueEmployer, Employer>{
	
	@Autowired
	private EmployerRepository EmployerRepository;

	@Override
	public void initialize(UniqueEmployer uniqueEployer) {
		
	}

	@Override
	public boolean isValid(Employer employer, ConstraintValidatorContext context) {
		boolean validEmail = validEmail(employer,context);

		return validEmail;
	}
	
	private boolean validEmail(Employer employer, ConstraintValidatorContext context) {
		String email = employer.getEmail();
		Employer tempEmployer = EmployerRepository.findByEmail(email);
		boolean isValid = true;
		if (tempEmployer != null
				&& (employer.getId() == null || !tempEmployer.getId().equals(
						employer.getId()))) {
			isValid = false;
			context.buildConstraintViolationWithTemplate(
					"Employer with such email allready exists")
					.addPropertyNode("email").addConstraintViolation();
		}
		return isValid;
	}

}
