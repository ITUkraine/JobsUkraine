package ua.com.jobsukraine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginInfoRepository lir;

	@Override
	public LoginInfo add(LoginInfo loginInfo) {
		return lir.save(loginInfo);
	}

	@Override
	public void delete(int id) {
		lir.delete(id);
	}

	@Override
	public LoginInfo edit(LoginInfo loginInfo) {
		return lir.saveAndFlush(loginInfo);
	}

	@Override
	public LoginInfo find(int id) {
		return lir.findOne(id);
	}

	@Override
	public LoginInfo findByLogin(String login) {
		return lir.findByLogin(login);
	}

}
