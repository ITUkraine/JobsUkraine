package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.LoginInfo;

public interface LoginInfoService {
	
	LoginInfo save(LoginInfo loginInfo);
	
	LoginInfo findByLogin(String login);
}
