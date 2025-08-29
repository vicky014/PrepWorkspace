package com.practise.workshop;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrences {
    public static void main(String[] args) {
        String str = "VikramGurubelli";

        // Count occurrences
//        Map<Character, Long> occurrences = str.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//
//        System.out.println("Character occurrences: " + occurrences);
//
//        // Find character with max occurrence
//        Map.Entry<Character, Long> maxEntry = occurrences.entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue())
//                .orElseThrow();
//
//        System.out.println("Character with most occurrences: " 
//                + maxEntry.getKey() + " -> " + maxEntry.getValue());
//        
//        
//        Map<Character,Long> occurencesTest = str.chars()
//        		.mapToObj(x -> (char) x)
//        		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        
//        Map.Entry<Character, Long> maxEntryTest = occurencesTest.entrySet()
//        		.stream()
//        		.max(Map.Entry.comparingByValue())
//        		.orElseThrow();
        
//        Map<Character,Long> occurences = str.chars()
//        		.mapToObj(x -> (char) x)
//        		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//        Map.Entry<Character, Long> resultMax = occurences.entrySet()
//        		.stream()
//        		.max(Map.Entry.comparingByValue())
//        		.orElseThrow();
//        
//        System.out.println(resultMax);\
        
        Map<Character,Long> occurences = str.chars()
        		.mapToObj(x ->(char) x)
        		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        Map.Entry<Character, Long> result = occurences.entrySet()
        		.stream()
        		.max(Map.Entry.comparingByValue())
        		.orElseThrow();
        		
        System.out.println(result);
        
    }
}

