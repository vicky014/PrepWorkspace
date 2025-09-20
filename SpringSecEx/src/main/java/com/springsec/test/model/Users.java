package com.springsec.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {

	@Id
	private Integer user_id;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="user_password")
	private String userpassword;

	public Users() {
		super();
	}

	public Users(Integer user_id, String username, String userpassword) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.userpassword = userpassword;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", userpassword=" + userpassword + "]";
	}

	
	
}
