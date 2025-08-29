package com.practise.prep;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class AllStreamMethodsDemo {
    public static void main(String[] args) {

        // ============================================
        // 1. STREAM CREATION
        // ============================================
        System.out.println("===== STREAM CREATION =====");
        List<String> list = Arrays.asList("John", "Jane", "Jack", "Anna", "John");

        Stream<String> streamFromList = list.stream();
        Stream<String> parallelStreamFromList = list.parallelStream();
        Stream<String> streamFromArray = Arrays.stream(new String[]{"A", "B", "C"});
        Stream<String> streamOf = Stream.of("X", "Y", "Z");
        Stream<Integer> iterateStream = Stream.iterate(0, n -> n + 2).limit(5);
        Stream<Double> generateStream = Stream.generate(Math::random).limit(3);

        iterateStream.forEach(System.out::println);
        generateStream.forEach(System.out::println);

        // ============================================
        // 2. INTERMEDIATE OPERATIONS
        // ============================================
        System.out.println("\n===== INTERMEDIATE OPERATIONS =====");

        // filter
        list.stream().filter(name -> name.startsWith("J")).forEach(System.out::println);

        // map
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        // mapToInt
        list.stream().mapToInt(String::length).forEach(System.out::println);

        // flatMap
        List<List<String>> nested = List.of(
            List.of("A", "B"),
            List.of("C", "D")
        );
        nested.stream().flatMap(List::stream).forEach(System.out::println);

        // distinct
        list.stream().distinct().forEach(System.out::println);

        // sorted natural order
        list.stream().sorted().forEach(System.out::println);

        // sorted custom order
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // peek
        list.stream().peek(System.out::println).map(String::length).forEach(System.out::println);

        // limit
        list.stream().limit(2).forEach(System.out::println);

        // skip
        list.stream().skip(3).forEach(System.out::println);

        // ============================================
        // 3. TERMINAL OPERATIONS
        // ============================================
        System.out.println("\n===== TERMINAL OPERATIONS =====");

        // forEach
        list.stream().forEach(System.out::println);

        // forEachOrdered (only visible in parallel)
        list.parallelStream().forEachOrdered(System.out::println);

        // toArray
        Object[] arr = list.stream().toArray();
        System.out.println(Arrays.toString(arr));

        // reduce
        String concatenated = list.stream().reduce("", (a, b) -> a + b);
        System.out.println("Concatenated: " + concatenated);

        // min
        list.stream().min(Comparator.naturalOrder()).ifPresent(min -> System.out.println("Min: " + min));

        // max
        list.stream().max(Comparator.naturalOrder()).ifPresent(max -> System.out.println("Max: " + max));

        // count
        System.out.println("Count: " + list.stream().count());

        // anyMatch
        System.out.println("Any match 'John': " + list.stream().anyMatch("John"::equals));

        // allMatch
        System.out.println("All start with J: " + list.stream().allMatch(name -> name.startsWith("J")));

        // noneMatch
        System.out.println("None start with Z: " + list.stream().noneMatch(name -> name.startsWith("Z")));

        // findFirst
        list.stream().findFirst().ifPresent(f -> System.out.println("First: " + f));

        // findAny
        list.parallelStream().findAny().ifPresent(a -> System.out.println("Any: " + a));

        // ============================================
        // 4. COLLECTORS & GROUPINGBY
        // ============================================
        System.out.println("\n===== COLLECTORS & GROUPINGBY =====");

        // toList
        List<String> collectedList = list.stream().collect(Collectors.toList());
        System.out.println(collectedList);

        // toSet
        Set<String> collectedSet = list.stream().collect(Collectors.toSet());
        System.out.println(collectedSet);

        // toMap
        Map<String, Integer> nameLengthMap = list.stream().collect(Collectors.toMap(
            Function.identity(),
            String::length,
            (existing, replacement) -> existing // merge function
        ));
        System.out.println(nameLengthMap);

        // joining
        String joined = list.stream().collect(Collectors.joining(", "));
        System.out.println(joined);

        // counting with groupingBy
        Map<Integer, Long> countByLength = list.stream().collect(Collectors.groupingBy(
            String::length,
            Collectors.counting()
        ));
        System.out.println(countByLength);

        // multi-level grouping
        Map<Integer, Map<Character, List<String>>> multiLevel = list.stream().collect(Collectors.groupingBy(
            String::length,
            Collectors.groupingBy(name -> name.charAt(0))
        ));
        System.out.println(multiLevel);

        // groupingBy with aggregation
        Map<Integer, String> joinedByLength = list.stream().collect(Collectors.groupingBy(
            String::length,
            Collectors.joining(" | ")
        ));
        System.out.println(joinedByLength);

        // groupingBy with custom map type
        TreeMap<Integer, Long> sortedCount = list.stream().collect(Collectors.groupingBy(
            String::length,
            TreeMap::new,
            Collectors.counting()
        ));
        System.out.println(sortedCount);

        // mapping inside groupingBy
        Map<Integer, List<Integer>> lengthToNameLengths = list.stream().collect(Collectors.groupingBy(
            String::length,
            Collectors.mapping(String::length, Collectors.toList())
        ));
        System.out.println(lengthToNameLengths);

        // ============================================
        // 5. PRIMITIVE STREAMS
        // ============================================
        System.out.println("\n===== PRIMITIVE STREAMS =====");

        // IntStream range
        IntStream.range(1, 5).forEach(System.out::println);

        // IntStream rangeClosed
        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        // sum, average, min, max
        System.out.println("Sum: " + IntStream.range(1, 5).sum());
        IntStream.range(1, 5).average().ifPresent(avg -> System.out.println("Average: " + avg));
        IntStream.range(1, 5).max().ifPresent(max -> System.out.println("Max: " + max));
        IntStream.range(1, 5).min().ifPresent(min -> System.out.println("Min: " + min));

        // boxed
        List<Integer> boxedList = IntStream.range(1, 5).boxed().toList();
        System.out.println(boxedList);

        // ============================================
        // 6. PARALLEL STREAMS
        // ============================================
        System.out.println("\n===== PARALLEL STREAMS =====");

        list.parallelStream()
            .filter(name -> name.length() > 3)
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}
