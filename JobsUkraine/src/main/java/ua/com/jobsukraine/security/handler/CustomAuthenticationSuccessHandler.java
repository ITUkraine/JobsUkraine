package ua.com.jobsukraine.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication)  {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		System.out.println(roles);
		Map<String, String> redirections = new HashMap<String,String>();
		redirections.put("ROLE_ADMIN","admin");
		redirections.put("ROLE_EMPLOYER","employerOffice");
		redirections.put("ROLE_CANDIDATE","candidateOffice");
		Iterator<String> it = roles.iterator();
		try {
			String role = it.next();
			response.sendRedirect(redirections.get(role));
		} catch (IOException e) {
			// TODO logs
			e.printStackTrace();
		}
	}

}
