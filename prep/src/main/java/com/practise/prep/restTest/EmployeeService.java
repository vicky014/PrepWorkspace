package com.practise.prep.restTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.prep.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	public void saveAll(List<Employee> empList) {
		empRepository.saveAll(empList);
		System.out.println("Data Updated");
	}
	
	public List<Employee> getAll() {
		return empRepository.findAll();
	}
}
