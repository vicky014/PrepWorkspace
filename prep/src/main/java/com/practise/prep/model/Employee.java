package com.practise.prep.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@Table(name = "employee")
public class Employee {

	@Id
	Integer empId;
	
	@Column
	String name;
	
	@Column
	double percentage;
	
	@Column
	Integer salary;
	
	@Column
	Integer cost;
	
	@Column
	String category;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}


	public Employee() {
		super();
	}

	public Employee(Integer empId, String name, double percentage, int salary, int cost, String category) {
		super();
		this.empId = empId;
		this.name = name;
		this.percentage = percentage;
		this.salary = salary;
		this.cost = cost;
		this.category = category;
	}

	public Employee(Integer empId, String name, double percentage, Integer salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.percentage = percentage;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", percentage=" + percentage + ", salary=" + salary
				+ "]";
	}
	
	
}
