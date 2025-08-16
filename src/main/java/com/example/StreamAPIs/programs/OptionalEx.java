package com.example.StreamAPIs.programs;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*In Java's Stream API, the Optional class often comes into play when working with terminal operations
that may or may not return a result, especially in cases like findFirst(), findAny(), max(), min(),
and reduce().
Avoids null (safer, more expressive)
Encourages handling of missing values explicitly (isPresent(), orElse(), etc.)
*/

public class OptionalEx {
    public static void main(String[] args) {

/*
findFirst() and findAny()
These methods return an Optional<T> because there might not be any elements in the stream.
*/
        List<String> names = List.of("Alice", "Bob", "Charlie");
        Optional<String> first = names.stream().findFirst();
        first.ifPresent(System.out::println); // prints "Alice"

        String result = names.stream()
                .filter(name -> name.startsWith("Z"))
                .findFirst()
                .orElse("No match");
        System.out.println(result);


/*
max() and min()
These also return Optional<T> because the stream could be empty.
*/
        List<Integer> numbers = List.of(5, 9, 1, 3);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        max.ifPresent(System.out::println); // prints 9

/*
reduce()
reduce() can return an Optional<T> depending on the overload you use.
*/
// No identity provided → returns Optional
        Optional<Integer> result1 = Stream.of(1, 2, 3,4).reduce((a, b) -> a + b);
        result1.ifPresent(System.out::println); // prints 10

// With identity → returns T (not Optional)
        Integer sum = Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);
        System.out.println(sum); // prints 6


/*        optional.ifPresent(value -> System.out.println(value));
        String value = optional.orElse("default");
        String value2 = optional.orElseGet(() -> computeDefault());
        String value3 = optional.orElseThrow(() -> new RuntimeException("No value"));*/


        List<User> users = List.of(
                new User("Alice", 30),
                new User("Bob", 25),
                new User("Charlie", 35),
                new User("David", 28)
        );
/*findFirst() with filter
Find the first user over 30:*/
            Optional<User> userOpt = users.stream()
                    .filter(u -> u.getAge() > 30)
                    .findFirst();
            userOpt.ifPresent(System.out::println);  // Output: Charlie (35)


/*max() — Find the oldest user*/
        Optional<User> oldestUser = users.stream()
                .max(Comparator.comparing(User::getAge));
        System.out.println("Oldest: " + oldestUser.orElse(null));  // Output: Charlie (35)

    /*map() after Optional
    * Let’s say we want just the name of the youngest user:
    * */
        Optional<String> youngestName = users.stream()
                .min(Comparator.comparing(User::getAge))
                .map(User::getName);  // maps User to String
        System.out.println("Youngest: " + youngestName.orElse("Unknown"));  // Output: Bob

/*Using orElse, orElseThrow*/
        User user = users.stream()
                .filter(u -> u.getName().equals("Zara"))
                .findFirst()
                .orElse(new User("Default", 0));
        System.out.println(user);  // Output: Default (0)

        //or throw exception
        User mustExist = users.stream()
                .filter(u -> u.getName().equals("Zara"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));


    }
}

