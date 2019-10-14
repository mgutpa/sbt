package com.sbt.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailure implements AuthenticationFailureHandler {

	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		if(exception instanceof BadCredentialsException){
			response.sendRedirect("?error=1"); 
		}else if(exception instanceof UsernameNotFoundException){
			response.sendRedirect("?error=3");
		}else if(exception instanceof ProviderNotFoundException){ 
			response.sendRedirect("?error=2");
		}else if(exception instanceof AuthenticationServiceException){ 
			response.sendRedirect("?error=4");
		}
	}

}
