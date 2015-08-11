package ua.com.jobsukraine.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.repository.LoginInfoRepository;

public class UniqueLoginInfoValidator  implements
ConstraintValidator<UniqueLoginInfo, LoginInfo> {

	@Autowired
	private LoginInfoRepository loginInfoRepository;
	
	@Override
	public void initialize(UniqueLoginInfo uniqueLoginInfo) {
		
	}

	@Override
	public boolean isValid(LoginInfo loginInfo, ConstraintValidatorContext context) {
		boolean validLogin = validLogin(loginInfo,context);
		return validLogin;
	}


	private boolean validLogin(LoginInfo loginInfo, ConstraintValidatorContext context) {

		String login = loginInfo.getLogin();
		LoginInfo tempLoginInfo = loginInfoRepository.findByLogin(login);
		boolean isValid = true;
		if (tempLoginInfo != null
				&& (loginInfo.getId() == null || !tempLoginInfo.getId().equals(
						loginInfo.getId()))) {
			isValid = false;
			context.buildConstraintViolationWithTemplate(
					"This login already exists")
					.addPropertyNode("login").addConstraintViolation();
		}
		return isValid;
	}
    
}
