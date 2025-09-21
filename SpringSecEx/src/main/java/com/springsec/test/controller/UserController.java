package com.springsec.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsec.test.model.Users;
import com.springsec.test.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
	
	@PostMapping("/register")
	public String register(@RequestBody Users user) {
		
		user.setUserpassword(encoder.encode(user.getUserpassword()));
		return userService.register(user);
	}
}
