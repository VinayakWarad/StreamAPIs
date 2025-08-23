package com.example.StreamAPIs.programs.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
flatMap:
Used to flatten nested structures (like Stream<Stream<T>>) into a single stream (Stream<T>).
Commonly used when working with lists of lists, arrays of arrays, or optional values.*/

public class flatMap2 {
    public static void main(String[] args) {

        int[] array1 = {1, 2};
        int[] array2 = {3, 4};

        int[] merged = Stream.of(array1, array2)
                .flatMapToInt(Arrays::stream)
                .toArray();
        System.out.println("Merged"+merged.toString());

    }
}

class flatMap3{
    public static void main(String[] args) {

        int[] array1 = {1, 2};
        int[] array2 = {3, 4};

        int[] merged = IntStream.concat(Arrays.stream(array1), Arrays.stream(array2))
                .toArray();
        System.out.println(Arrays.toString(merged)); // [1, 2, 3, 4]
    }
}

class flatMap4{
    public static void main(String[] args) {

System.out.println("Convert String arraylist to string list and letter should be split to string");
List<String> words = Arrays.asList("Hello", "World");
List<String> characters = words.stream()
        .flatMap(word -> Arrays.stream(word.split("")))
        .map(a->a.toUpperCase())
        .collect(Collectors.toList());  // terminal operation
        characters.forEach(s->System.out.println(s));

System.out.println("flatMap is also used in the Optional class to unwrap nested Optionals.");
        Optional<String> name = Optional.of("Alice");
        Optional<Integer> nameLength = name.flatMap(n -> Optional.of(n.length()));
        System.out.println(nameLength);// nameLength contains Optional[5]
/*        For above example if we use map instead of flatMap
        You would end up with a nested Optional: Optional[Optional[5]].
        So, flatMap helps flatten nested Optionals, just like it does with streams.*/
        Optional<Optional<Integer>> result = name.map(n -> Optional.of(n.length()));
        System.out.println(result);



    }
}