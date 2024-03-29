package com.sbt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sbt.dao.UserDAOImpl;
import com.sbt.model.CustomUser;

@Service
public class CustomUserService implements UserDetailsService {

	 @Autowired
	 private UserDAOImpl userDao;
	 
	 
	public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}

}