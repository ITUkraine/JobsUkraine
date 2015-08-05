package ua.com.jobsukraine.service.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.jobsukraine.security.CustomAuthenticationProvider;
import ua.com.jobsukraine.security.handler.CustomAuthenticationSuccessHandler;
import ua.com.jobsukraine.service.SecurityService;

@Service
@ComponentScan(basePackages ={"ua.com.jobsukraine.security.handler", "ua.com.jobsukraine.security"})
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Override
	public void autoLoginAfterRegistration(HttpServletRequest request, HttpServletResponse response, String username, String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = customAuthenticationProvider.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(auth);
		request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
				SecurityContextHolder.getContext());
		try {
			customAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, auth);
		} catch (IOException e) {
			// TODO logs
			e.printStackTrace();
		}
	}


}
