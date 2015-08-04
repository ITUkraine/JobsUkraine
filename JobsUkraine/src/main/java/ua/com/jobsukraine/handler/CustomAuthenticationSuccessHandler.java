package ua.com.jobsukraine.handler;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;  

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {  
  
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        
        HttpSession session = request.getSession();  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        session.setAttribute("username", auth.getName());  
        session.setAttribute("authorities", authentication.getAuthorities());  
        try{
        	if (roles.contains("ROLE_CANDIDATE")) {
                response.sendRedirect("candidateOffice");
            }else if(roles.contains("ROLE_EMPLOYER")){
            	response.sendRedirect("employerOffice");
            }else response.sendRedirect("admin");
        }catch(Exception e){
        	e.printStackTrace();
        	}
        
    } 
} 
