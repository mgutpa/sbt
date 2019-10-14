package com.sbt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sbt.model.CustomUser;
import com.sbt.model.Role;

@Repository
public class UserDAOImpl {
	
	 public CustomUser loadUserByUsername(final String username) {
		 //Write your DB call code to get the user details from DB,But I am just hard coding the user
		 	CustomUser user = new CustomUser();
	        user.setFirstName("Admin");
	        user.setLastName("Team");
	        user.setUsername("admin");
	        user.setPassword("admin");
	        Role r = new Role();
	        r.setName("ROLE_USER");
	        List<Role> roles = new ArrayList<Role>();
	        roles.add(r);
	        user.setAuthorities(roles);
	        return user;
	    }

}