package com.springsec.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsec.test.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer >{
//	Users findByUserName(String username);

	Users findByUsername(String username);

}
