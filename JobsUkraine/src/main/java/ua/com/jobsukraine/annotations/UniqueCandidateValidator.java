package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.entity.Candidate;
import ua.com.jobsukraine.repository.CandidateRepository;

public class UniqueCandidateValidator  implements
ConstraintValidator<UniqueCandidate, Candidate>{
	
	@Autowired
	private CandidateRepository candidateRepository;

	@Override
	public void initialize(UniqueCandidate uniqueCandidate) {
		
	}

	@Override
	public boolean isValid(Candidate candidate, ConstraintValidatorContext context) {
		boolean validEmail = validEmail(candidate,context);

		return validEmail;
	}
	
	private boolean validEmail(Candidate candidate, ConstraintValidatorContext context) {
		String email = candidate.getEmail();
		Candidate tempCandidate = candidateRepository.findByEmail(email);
		boolean isValid = true;
		if (tempCandidate != null
				&& (candidate.getId() == null || !tempCandidate.getId().equals(
						candidate.getId()))) {
			isValid = false;
			context.buildConstraintViolationWithTemplate(
					"Candidate with such email allready exists")
					.addPropertyNode("email").addConstraintViolation();
		}
		return isValid;
	}

}
