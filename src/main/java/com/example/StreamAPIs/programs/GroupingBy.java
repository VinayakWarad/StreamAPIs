package com.example.StreamAPIs.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

 public class GroupingBy {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 28, "HR"));
        employees.add(new Employee("Bob", 32, "IT"));
        employees.add(new Employee("Charlie", 25, "HR"));
        employees.add(new Employee("Diana", 30, "Finance"));
        employees.add(new Employee("Eve", 27, "IT"));
        employees.add(new Employee("Frank", 40, "Finance"));

        // Count employees in each department
        Map<String, Long> empCountByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));

        // Print the results
        empCountByDept.forEach((dept, count) ->
                System.out.println(dept + " -> " + count + " employees")
        );
    }
}
