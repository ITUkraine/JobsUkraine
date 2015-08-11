package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.repository.EmployerRepository;

public class UniqueEmployerEmailValidator  implements
ConstraintValidator<UniqueEmployerEmail, String>{
	
	@Autowired
	private EmployerRepository employerRepository;

	@Override
	public void initialize(UniqueEmployerEmail uniqueEployerEmail) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
        if(employerRepository==null){
        	return true;
        }
		return employerRepository.findByEmail(email)==null;
	}
	

}
