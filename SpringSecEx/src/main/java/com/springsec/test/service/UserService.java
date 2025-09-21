package com.springsec.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsec.test.model.Users;
import com.springsec.test.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public String register(Users user) {
		
		userRepo.save(user);
		return "User Registered";
	}

}
