package com.springsec.test.model;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrniciple implements UserDetails{

	private Users user;
	
	public UserPrniciple(Users user) {
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		
		return user.getUserpassword();
	}

	@Override
	public String getUsername() {
		
		return user.getUsername();
	}

}
