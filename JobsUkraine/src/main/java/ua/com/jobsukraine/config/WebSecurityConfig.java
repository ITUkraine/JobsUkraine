package ua.com.jobsukraine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ua.com.jobsukraine.handler.CustomAuthenticationSuccessHandler;
import ua.com.jobsukraine.service.impl.CustomAuthenticationProvider;


@Configuration
@EnableWebSecurity
@ComponentScan(basePackages ={"ua.com.jobsukraine.service.impl","ua.com.jobsukraine.handler"})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/**").permitAll()
                .anyRequest().permitAll()
                .and();
		
        http.formLogin()               
                .loginPage("/login")            
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?error").successHandler(customAuthenticationSuccessHandler)      
                .usernameParameter("j_username")
                .passwordParameter("j_password")                
                .permitAll();
 
        http.logout()
                .permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.authenticationProvider(customAuthenticationProvider);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}