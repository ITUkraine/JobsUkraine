package ua.com.jobsukraine.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.SecurityService;

@Service
@ComponentScan(basePackages = { "ua.com.jobsukraine.security.handler", "ua.com.jobsukraine.security" })
@Transactional
public class SecurityServiceImpl implements SecurityService {

	final static Logger logger = Logger.getLogger(SecurityServiceImpl.class);

	@Autowired
	@Qualifier(value = "customAuthenticationProvider")
	private AuthenticationProvider customAuthenticationProvider;
	@Autowired
	@Qualifier(value = "customAuthenticationSuccessHandler")
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void autoLoginAfterRegistration(HttpServletRequest request, HttpServletResponse response, String username,
			String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication authentication = customAuthenticationProvider.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());

		try {
			customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);
		} catch (ServletException e) {

			logger.debug("THIS IS ServletException", e);

		} catch (IOException e) {

			logger.debug("THIS IS IOException", e);
		}

	}

	@Override
	public void encodePassword(LoginInfo loginInfo) {
		loginInfo.setPassword(bCryptPasswordEncoder.encode(loginInfo.getPassword()));
	}

}
