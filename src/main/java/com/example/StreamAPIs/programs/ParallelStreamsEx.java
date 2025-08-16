package com.example.StreamAPIs.programs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*A parallel stream splits the data into chunks, processes them in parallel threads, and combines the results.*/
public class ParallelStreamsEx {
    public static void main(String[] args) {

//Ex 1 :
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        names.parallelStream()
                .forEach(System.out::println);  // Output may be out of order

//EX : 2 : Example of both parallel and sequential in one pgm
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                .boxed()
                .collect(Collectors.toList());

        // Sequential Stream
        long startSeq = System.currentTimeMillis();
        long sumSeq = numbers.stream()
                .mapToLong(n -> n * n)
                .sum();
        long timeSeq = System.currentTimeMillis() - startSeq;

        // Parallel Stream
        long startPar = System.currentTimeMillis();
        long sumPar = numbers.parallelStream()
                .mapToLong(n -> n * n)
                .sum();
        long timePar = System.currentTimeMillis() - startPar;

        System.out.println("Sequential sum: " + sumSeq + " in " + timeSeq + " ms");
        System.out.println("Parallel sum:   " + sumPar + " in " + timePar + " ms");
/*
Sequential sum: 333333383333335000000 in 420 ms
Parallel sum:   333333383333335000000 in 140 ms
*/

    }
}
