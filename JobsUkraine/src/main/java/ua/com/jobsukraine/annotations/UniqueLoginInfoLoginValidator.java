package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.repository.LoginInfoRepository;

public class UniqueLoginInfoLoginValidator implements ConstraintValidator<UniqueLoginInfoLogin, String> {

	@Autowired
	private LoginInfoRepository loginInfoRepository;

	@Override
	public void initialize(UniqueLoginInfoLogin uniqueLoginInfo) {

	}

	@Override
	public boolean isValid(String login, ConstraintValidatorContext context) {
		if (loginInfoRepository == null) {
			return true;
		}
		return loginInfoRepository.findByLogin(login)==null;
	}

}
