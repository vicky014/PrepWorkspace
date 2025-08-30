package com.practise.prep.restTest;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practise.prep.model.Employee;

@Component
public class EmployeeDataLoader implements CommandLineRunner{

	private EmployeeService empService;
	
	public EmployeeDataLoader(EmployeeService empService) {
		this.empService= empService;
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		empService.saveAll(Arrays.asList(
                new Employee(1, "A", 80,1000,200,"X"),
                new Employee(2, "B", 80,1000,100,"X"),
                new Employee(3, "C", 80,1000,90,"Y"),
                new Employee(4, "D", 80,1000,250,"Y"),
                new Employee(5, "E", 80,1000,30,"Z"),
                new Employee(6, "F", 80,1000,10,"Z"),
                new Employee(7, "G", 80,1000,50,"X")
        ));
		
		System.out.println("Calling all data");
		empService.getAll().forEach(x -> System.out.println(x.toString()));
	}

}
