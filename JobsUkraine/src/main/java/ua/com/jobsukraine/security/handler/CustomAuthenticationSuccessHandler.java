package ua.com.jobsukraine.security.handler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component(value = "customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		response.sendRedirect(initRoleMap().get(roles.iterator().next()));
	}

	private Map<String, String> initRoleMap() {
		Map<String, String> redirections = new HashMap<String, String>();
		redirections.put("ROLE_ADMIN", "admin");
		redirections.put("ROLE_EMPLOYER", "employerOffice");
		redirections.put("ROLE_CANDIDATE", "candidateOffice");
		return redirections;
	}
}
