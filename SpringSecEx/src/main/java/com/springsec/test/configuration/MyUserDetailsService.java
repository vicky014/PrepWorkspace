package com.springsec.test.configuration;

import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsec.test.model.UserPrniciple;
import com.springsec.test.model.Users;
import com.springsec.test.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override  
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = userRepo.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserPrniciple(user);
	}

}
