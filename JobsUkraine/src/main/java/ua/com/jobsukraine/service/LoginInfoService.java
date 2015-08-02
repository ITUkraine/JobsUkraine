package ua.com.jobsukraine.service;

import ua.com.jobsukraine.entity.LoginInfo;

public interface LoginInfoService extends DefaultService<LoginInfo> {
	LoginInfo findByLogin(String login);
}
