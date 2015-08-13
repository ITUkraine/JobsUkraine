package ua.com.jobsukraine.utils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class PrincipalGenerator {

	public static Authentication getPrincipal(String login, String pass, String[] roles) {
		User user = new User(login, pass, AuthorityUtils.createAuthorityList(roles));
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null);
		SecurityContextHolder.getContext().setAuthentication(auth);
		return auth;
	}

}
