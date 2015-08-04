package ua.com.jobsukraine.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import ua.com.jobsukraine.entity.LoginInfo;
import ua.com.jobsukraine.service.LoginInfoService;

@Component
@ComponentScan(basePackages ="ua.com.jobsukraine.service.impl")
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	@Autowired
	private LoginInfoService lis;
	
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	String name = authentication.getName();
        String password = authentication.getCredentials().toString();
    	
    	LoginInfo user = lis.findByLogin(name);
    	if(user==null) return null;
        if (name.equals(user.getLogin()) && password.equals(user.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority(user.getRole().getName()));
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return auth;
        } else {
            return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

