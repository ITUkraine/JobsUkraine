package ua.com.jobsukraine.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "ua.com.jobsukraine.security.handler", "ua.com.jobsukraine.security" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("customAuthenticationProvider")
	private AuthenticationProvider customAuthenticationProvider;
	@Autowired
	@Qualifier(value = "customAuthenticationSuccessHandler")
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/JobsUkraine", "contacts", "aboutUs").permitAll().antMatchers("/admin")
				.hasRole("ADMIN").and().exceptionHandling().accessDeniedPage("/accessDenied");
		http.csrf().disable().authorizeRequests().antMatchers("/resources/**", "/**").permitAll().anyRequest()
				.permitAll();

		http.formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check").failureUrl("/login?error")
				.successHandler(customAuthenticationSuccessHandler).usernameParameter("j_username")
				.passwordParameter("j_password").permitAll();

		http.logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/").invalidateHttpSession(true);

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() throws Exception {
		return new BCryptPasswordEncoder();
	}
}