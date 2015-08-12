package ua.com.jobsukraine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginInfoRepository loginInfoRepository;

	@Override
	public LoginInfo save(LoginInfo loginInfo) {
		return loginInfoRepository.save(loginInfo);
	}

	@Override
	public LoginInfo findByLogin(String login) {
		return loginInfoRepository.findByLogin(login);
	}

}
