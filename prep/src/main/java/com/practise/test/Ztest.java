package com.practise.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ztest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {5,2,9,15,12,20};
//		int target = 10;
//		
//		int num = Arrays.stream(arr)
//				.boxed()
//				.min((a,b) -> Math.abc)
	
		String input = "The wuicvck brown foix jump over the lazy dog";
		
		Map<Character,Long> freq = input.chars()
				.mapToObj(c -> (char) c)
				.filter(Character::isLetter)
				.map(Character::toLowerCase)
				
				.collect(Collectors.groupingBy(Function.identity(),TreeMap::new,Collectors.counting()));
		
		long max = freq.values().stream()
				.mapToLong(Long::longValue)
				.max()
				.orElse(0);
		System.out.println(freq+" : "+max);
		
	}

}
