package com.sbt.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import com.sbt.model.CustomUser;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
    private CustomUserService userService;
   
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
          String username = authentication.getName();
          String password = (String) authentication.getCredentials();
     
            CustomUser user = userService.loadUserByUsername(username);
     
            if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
                throw new BadCredentialsException("Username not found.");
            }
     
            if (!password.equals(user.getPassword())) {
                throw new BadCredentialsException("Wrong password.");
            }
     
            Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
     
            return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
 
    public boolean supports(Class<?> arg0) {
        return true;
    }

}
