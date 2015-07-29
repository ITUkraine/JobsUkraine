package ua.com.jobsukraine.service;

import java.util.List;

import ua.com.jobsukraine.entity.LoginInfo;

public interface LoginInfoService {
	LoginInfo add(LoginInfo loginInfo);
	void delete(int id);
	LoginInfo edit(LoginInfo loginInfo);
	List<LoginInfo> getAll();
}
