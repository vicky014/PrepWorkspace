package com.practise.workshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicacyRemoval {

	/*
	 * removing duplicacy using java 8
	 */
	public static void removalOfDuplicacyWJava8(List<String> duplicacyList) {

		List<String> result = duplicacyList.stream().distinct().collect(Collectors.toList());
		System.out.println("----------With Java8------");
		
		Set<String> resultSet1 = duplicacyList.stream().collect(Collectors.toSet());
		List<String> result1 = new ArrayList<>(resultSet1);
		
		
		System.out.println("----------Approach 1------");
		result.forEach(x -> System.out.println(x));
		System.out.println("----------Approach 2------");
		result1.forEach(x -> System.out.println(x));
	}
	
	public static void removalOfDuplicacyWoJava8(List<String> duplicacyList) {
		
		Set<String> result = new HashSet<>(duplicacyList);
		System.out.println("----------Without Java8------");
		result.forEach(x -> System.out.println(x));
	}
	
	public static void main(String[] args) {
		
		List<String> duplicacyList = new ArrayList<>();
		duplicacyList = Arrays.asList("A","A","B","C","c");

		removalOfDuplicacyWJava8(duplicacyList);
		
		removalOfDuplicacyWoJava8(duplicacyList);
		
	}
}
