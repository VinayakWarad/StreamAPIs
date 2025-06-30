package com.example.StreamAPIs.programs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
/*
Intermediate Operations

Method	        Description
filter()	    Filters elements based on a predicate.
map()	        Transforms each element using a function.
flatMap()	    Flattens nested structures (like List<List<T>>).
distinct()	    Removes duplicates.
sorted()	    Sorts elements (natural or custom order).
limit(n)	    Truncates the stream to n elements.
skip(n)	        Skips the first n element.
peek()	        Performs an action on each element (mainly for debugging).  */

System.out.println("Print Integer stream elements");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .forEach(x -> System.out.println(x));

        System.out.println("Print String stream elements");
        Stream.of("a", "b", "10", "d")
                .forEach(s -> {if(s.equals("10")){
            System.out.println("String stream contains 10");
        }});

// Ex 3 : filter and collect to List
        Stream.of("A", "b", "c", "d")
                .filter(a -> {
                    if (a.equals("A") || a.equals("b"))
                    {  return true;  }
                    return false;
                }).collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);



        System.out.println("Convert string to lowercase and get first 3 of them " +
                "and convert to uppercase and later print top 3");
        Stream.of("A", "b", "C", "d")
                .map(String::toLowerCase) // .map(a->a.toUpperCase)
                .limit(3)
                .collect(Collectors.toList())
                .stream()
                .map(a -> a.toUpperCase(Locale.ROOT))
                .forEach(System.out::println);

        System.out.println("Skip first 2 objects of stream and print remaining entries");
        Stream.of("A", "b", "C", "d")
                .skip(2)
                .collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);

/*
Ex 5 : peek is mostly used for logging / Debugging purpose
    peek() is lazy: it won't execute unless there is a terminal operation (like forEach, collect, etc.).
    It’s not intended to modify elements. For transformations, use map() instead.
*/
        Stream.of("A", "b", "C", "d")
                .map(a -> a.toLowerCase(Locale.ROOT))
                .limit(3)
                .peek(a -> System.out.println(a))
                .collect(Collectors.toList())
                .stream()
                .toList()
                .forEach(System.out::println);


System.out.println("Count of strings in stream");
        long cnt = Stream.of("A", "b", "C", "d")
                .count();
        System.out.println(cnt);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Vinayak", 28, 98299388399l));
      //  studentList.add(new Student("Vinayak", 28, 98299388399l));
        studentList.add(new Student("Vishwa", 29, 98299388399l));
        studentList.add(new Student("Akshay", 30, 98299388399l));

        System.out.println("How many times string Vinayak is duplicated in list");
        long count = studentList.stream()
                        .filter(std -> std.getName().equals("Vinayak"))
                        .collect(Collectors.toList())
                        .stream()
                        .count();
                System.out.println(count + "Count");

        System.out.println("Count of student names which starts with A");
        long startsWithA = studentList.stream()
                                    .filter(a -> a.getName().startsWith("A"))
                                    .count();
                                System.out.println(startsWithA);

        System.out.println("List student names that starts with A");
        studentList.stream()
                .filter(a -> a.getName().startsWith("A"))
                .peek(a -> System.out.println(a))
                .map(a -> a.getName())
                .forEach(System.out::println);

        System.out.println("Print distinct strings");
        Stream.of("A", "b", "C", "b")
                .distinct()
                .forEach(System.out::println);

        System.out.println("Sorting");
        Stream.of(1, 42, 3, 4, 5, 8, 3, 9)
                .sorted()
                .collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);


        System.out.println("Reverse Sorting");
        Stream.of(1, 42, 3, 4, 5, 8, 3, 9)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .stream()
                .forEach(System.out::println);
/*

FlatMap
The flatMap intermediate method is used to flatten nested structures (like lists of lists) into a single stream.
When each element in a stream is itself a collection or stream, and you want to process the individual
elements inside those nested collections.*/

            //mapToLong,flatMapToInt
System.out.println("Iterate through students list and save name and age as key value pair in map");
Map<String,Integer> stdnts=studentList.stream()
                                .collect(Collectors.toMap(a->a.getName(),a-> a.getAge()));

System.out.println("Take student list and get name as key and value as age and store it in map" +
        "then iterate map and print map entries");
/*Map<String,Integer> stdnts=*/studentList.stream()
                       // .filter(std -> std.getName().equals("Vinayak"))
                        .collect(Collectors.toMap(a->a.getName(),a-> a.getAge()))
                        .entrySet()
                        .stream()
                        .forEach(System.out::println);



}
}
