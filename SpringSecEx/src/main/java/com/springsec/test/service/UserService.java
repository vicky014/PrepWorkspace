package com.springsec.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.springsec.test.model.Users;
import com.springsec.test.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtService jwtService;
	
	public Users register(Users user) {
		return userRepo.save(user);
	}

	public String verify(Users user) {
		
		Authentication authenticate = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getUserpassword()));
		if(authenticate.isAuthenticated())
				return jwtService.generateToken(user.getUsername());
		return "Fail";
	}

}
