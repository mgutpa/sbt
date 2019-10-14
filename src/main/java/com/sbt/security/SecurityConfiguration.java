package com.sbt.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.sbt.service.CustomAuthenticationFailure;
import com.sbt.service.CustomAuthenticationProvider;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/secured/**").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin().loginPage("/login").failureHandler(new CustomAuthenticationFailure()).and().httpBasic();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticator());
		auth.eraseCredentials(false);
	    super.configure(auth);

	}
	
	@Bean 
	public AuthenticationProvider authenticator() {
	  return new CustomAuthenticationProvider();
	}

	
	
}
