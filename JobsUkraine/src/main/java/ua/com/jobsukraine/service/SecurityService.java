package ua.com.jobsukraine.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.jobsukraine.entity.LoginInfo;

public interface SecurityService {
	void autoLoginAfterRegistration(HttpServletRequest request, HttpServletResponse response,String username, String password);
	void encodePassword(LoginInfo loginInfo);
}
