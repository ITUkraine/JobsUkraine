package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.repository.CandidateRepository;

public class UniqueCandidateEmailValidator  implements
ConstraintValidator<UniqueCandidateEmail, String>{
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public void initialize(UniqueCandidateEmail uniqueCandidateEmail) {
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
        if(candidateRepository==null){
        	return true;
        }
		return candidateRepository.findByEmail(email) == null;
	}

}
