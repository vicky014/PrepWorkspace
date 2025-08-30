package com.practise.prep;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practise.prep.model.Employee;
import com.practise.prep.restTest.EmployeeService;

@SpringBootApplication
public class PrepApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrepApplication.class, args);
		System.out.println("Hello Prep World");

	}

}
