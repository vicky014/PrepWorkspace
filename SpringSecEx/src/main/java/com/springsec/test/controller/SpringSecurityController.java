package com.springsec.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsec.test.model.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SpringSecurityController {

	@GetMapping("/home")
	public String testCall(HttpServletRequest request) {
		return "Welcome to Spring Security Test"+request.getSession().getId();
	}
	
	@GetMapping("/csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@PostMapping("/addEmployeeList")
	public List<Employee> addAll(@RequestBody List<Employee> employeeList){
		
		List<Employee> empList = new ArrayList<>();
		Employee s1 = new Employee("1","Vikram",8.75);
		empList.add(s1);
		
		return empList;
	}
}
