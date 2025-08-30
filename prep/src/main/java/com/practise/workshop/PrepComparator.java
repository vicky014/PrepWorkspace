package com.practise.workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.practise.prep.model.Employee;

public class PrepComparator {

	public static void main(String[] args) {
		
		List<Employee> empList = new ArrayList<>();
		
		Employee e1 = new Employee(1, "Vikram", 91.5, 500000);
		Employee e2 = new Employee(2, "Manju", 81.5, 500000);
		Employee e3 = new Employee(3, "Vinod", 71.5, 600000);
		Employee e4 = new Employee(4, "Saikanth", 61.5, 700000);

		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		
		System.out.println("before formatting");
		empList.forEach(x -> System.out.println(x));
//		
		System.out.println("post sort by name without java 8 ");
		empList.sort((Employee o1, Employee o2) -> o1.getName().compareTo(o2.getName()));
		empList.forEach(x -> System.out.println(x));
		
//		List<Employee> sortedList = empList.stream()
//				.sorted(Comparator.comparing(Employee::getName).reversed()
//				.thenComparing(Employee::getSalary))
//				.collect(Collectors.toList());
		
//		List<Employee> sortedList = empList.stream()
//				.sorted(Comparator.comparing((Employee e)-> e.getName()).reversed()
//				.thenComparing((Employee e) -> e.getSalary()))
//				.collect(Collectors.toList());
		
//		List<Employee> sortedList = empList.stream()
//				.sorted(Comparator.comparing((Employee e)-> e.getName()).reversed())
//				.collect(Collectors.toList());
//		System.out.println("post sort by name with java 8");
//		sortedList.forEach(x -> System.out.println(x));
//		
//		sortedList.sort((Employee o1, Employee o2) -> o1.getSalary().compareTo(o2.getSalary()));
//		System.out.println("post sort by salary with java 8");
//		sortedList.forEach(x -> System.out.println(x));
		
		List<Employee> sortedList = empList.stream()
				.sorted(Comparator.comparing(Employee::getName).reversed())
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println("post sort by name with java 8");
		sortedList.forEach(x -> System.out.println(x));
		
		System.out.println("**********");
		
//		empList.forEach(x -> System.out.println(x));
//		List<Employee> sortedList1 = empList.stream().sorted()
//				.collect(Collectors.toList());
//		System.out.println("post default sort with java 8");
//		sortedList1.forEach(x -> System.out.println(x));

//		sortedList.sort((Employee o1, Employee o2) -> o1.getSalary().compareTo(o2.getSalary()));
//		System.out.println("post sort by salary with java 8");
//		sortedList.forEach(x -> System.out.println(x));
		
		
		System.out.println("88888888888888888");
		
		// Using map
		List<String> list = Arrays.asList("a,b", "c,d");
		List<List<String>> mapList = list.stream().map(s -> Arrays.asList(s.split(","))).collect(Collectors.toList());
		
		mapList.forEach(x -> System.out.println("Map : "+x));
		// → List<List<String>>

		// Using flatMap
		List<String> flatMapList = list.stream().flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toList());
		flatMapList.forEach(x -> System.out.println("Flatmap : "+x));
		// → List<String>

		List<Integer> intList = Arrays.asList(1,2,3,4,5);
		intList.stream()
	    .peek(e -> System.out.println("processing: " + e))
	    .filter(x -> x > 2)
	    .count();
		
		List<String> resultEmpList = empList.stream()
        .filter(s -> s.getPercentage() > 60)
        .sorted(Comparator.comparing(Employee::getName))
        .limit(3)
        .map(Employee::getName)
        .collect(Collectors.toList());

		resultEmpList.forEach(x -> System.out.println(x));
		
		List<Employee> resultEmpList1 = empList.stream()
		        .filter(s -> s.getPercentage() > 60)
		        .sorted(Comparator.comparing(Employee::getName))
		        .limit(3)
//		        .map(Employee::getName)
		        .collect(Collectors.toList());
		
		resultEmpList1.forEach(x -> System.out.println(x));

		
		List<Integer> intList1 = Arrays.asList(1,2,3,4,5,5,1);
		
		intList1.stream().distinct().forEach(x -> System.out.println("distinct : "+x));
		
				
		Consumer<String> upperPrinter = str -> System.out.println(str.toUpperCase());
        upperPrinter.accept("vikram"); // Output: VIKRAM
		
		
	}

}
