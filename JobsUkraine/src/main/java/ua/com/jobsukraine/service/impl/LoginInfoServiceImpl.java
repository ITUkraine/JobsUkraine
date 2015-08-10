package ua.com.jobsukraine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.repository.LoginInfoRepository;
import ua.com.jobsukraine.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginInfoRepository liLoginInfoRepository;

	@Override
	public LoginInfo add(LoginInfo loginInfo) {
		return liLoginInfoRepository.save(loginInfo);
	}

	@Override
	public void delete(int id) {
		liLoginInfoRepository.delete(id);
	}

	@Override
	public LoginInfo edit(LoginInfo loginInfo) {
		return liLoginInfoRepository.saveAndFlush(loginInfo);
	}

	@Override
	public LoginInfo find(int id) {
		return liLoginInfoRepository.findOne(id);
	}

	@Override
	public LoginInfo findByLogin(String login) {
		return liLoginInfoRepository.findByLogin(login);
	}

}
