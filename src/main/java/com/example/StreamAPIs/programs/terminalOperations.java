package com.example.StreamAPIs.programs;

import java.util.*;
import java.util.stream.Collectors;

public class terminalOperations {
    public static void main(String[] args) {

/*Operation	    Description

collect()	    Gathers the elements into a collection (like List, Set, Map, etc.).
forEach()	    Performs an action for each element. Usually used for printing or side effects.
toArray()	    Converts the stream to an array.
reduce()	    Reduces the elements to a single value using an accumulator.
count()	        Returns the number of elements in the stream.
anyMatch()	    Returns true if any element matches the predicate.
allMatch()	    Returns true if all elements match the predicate.
noneMatch()	    Returns true if no elements match the predicate.
findFirst()	    Returns the first element wrapped in Optional.
findAny()	    Returns any element (non-deterministic in parallel streams).
min()/max()	    Returns the minimum or maximum element based on a comparator. */


System.out.println("Find maximum number");
List<Integer> numbers = List.of(10, 20, 5, 30);
Optional<Integer> max = numbers.stream()
        .reduce((a, b) -> a > b ? a : b);
max.ifPresent(System.out::println); // Output: 30

/*🔁 For addition (a + b):
        The identity is 0, because:
        0 + x = x for any number x.

💡 Other examples:
Operation	     Identity
Addition	     0
Multiplication	 1
String concat	 ""
Finding          max	Integer.MIN_VALUE (in some cases)
Finding          min_Integer.MAX_VALUE (in some cases)*/

System.out.println("Concat all string values");
List<String> names = List.of("Vinayak", "Nireeksha", "Mukta");
String result = names.stream()
        .reduce("", (a, b) -> a + b);
System.out.println(result); // Output: VinayakNireekshaMukta

System.out.println("SUm of integers");
List<Integer> nums = List.of(1, 2, 3, 4, 5);
int sum = numbers.stream()
        .reduce(0, (a, b) -> a + b);
System.out.println(nums); // Output: 15

List<Student> studentList = new ArrayList<>();
studentList.add(new Student("Vinayak", 28, 98299388399l));
studentList.add(new Student("Vishwa", 29, 98299388399l));
studentList.add(new Student("Akshay", 30, 98299388399l));

System.out.println("Reduce to total age");
int totalAge = studentList.stream()
        .map(Student::getAge)
        .reduce(0, Integer::sum); // same as (a, b) -> a + b
System.out.println("Total age: " + totalAge); // Output: Total age: 87

System.out.println("Find the oldest student using reduce");
Optional<Student> oldest = studentList.stream()
        .reduce((s1, s2) -> s1.getAge() > s2.getAge() ? s1 : s2);
oldest.ifPresent(s ->
        System.out.println("Oldest: " + s.getName() + ", Age: " + s.getAge())
); // Output: Oldest: Akshay, Age: 30


System.out.println("Print student with 2nd highest age");
Optional<Student> secondHighestStudent = studentList.stream()
        .sorted(Comparator.comparingInt(Student::getAge).reversed()) // sort by age descending
        .distinct() // this only works if equals/hashCode is overridden (optional in this case)
        .skip(1)    // skip the highest
        .findFirst(); // take the second one
secondHighestStudent.ifPresent(s ->System.out.println("Second highest student: " + s));

/*If there are multiple students with the same highest age, and you only want unique ages,
you need to handle it slightly differently:*/
System.out.println("Unique ages with second-highest student");
Optional<Student> secondHighestStdnt = studentList.stream()
    .collect(Collectors.groupingBy(Student::getAge)) // group students by age
    .entrySet().stream()
    .sorted((e1, e2) -> Integer.compare(e2.getKey(), e1.getKey())) // sort by age descending
    .skip(1)
    .findFirst()
    .flatMap(e -> e.getValue().stream().findFirst()); // pick any student with that age
secondHighestStudent.ifPresent(s -> System.out.println("Second highest student: " + s));

//Boolean - If anyMatch happens then streaming will stop at that point itself - COntains -
System.out.println("anyMatch");
boolean hasTeen = studentList.stream()
        .anyMatch(s -> s.getAge() >= 13 && s.getAge() <= 19);
System.out.println("Returns true if-Has teenager? " + hasTeen);

System.out.println("anyMatch1");
boolean containsVinayak = studentList.stream()
        .anyMatch(s -> s.getName().equalsIgnoreCase("Vinayak"));
System.out.println("Returns true if Contains Vinayak? " + containsVinayak);

//Boolean -allMatch() Returns true if every element matches the condition.
boolean allAdults = studentList.stream()
        .allMatch(s -> s.getAge() >= 18);
System.out.println("Returns true if-All students are adults? " + allAdults);

boolean noMinors = studentList.stream()
        .noneMatch(s -> s.getAge() < 18);
System.out.println("Returns true if No minors in the list? " + noMinors);


System.out.println(" Finding Min and Max with Java Streams");
List<Integer> numbs = Arrays.asList(10, 25, 3, 99, 47, 6);
// Find minimum
Optional<Integer> min = numbers.stream().min(Integer::compareTo);
// Find maximum
Optional<Integer> maxi = numbers.stream().max(Integer::compareTo);
// Print results
min.ifPresent(m -> System.out.println("Min: " + m));
maxi.ifPresent(m -> System.out.println("Max: " + m));
//Optional<T> is a container object that may or may not contain a non-null value.

    }
}
