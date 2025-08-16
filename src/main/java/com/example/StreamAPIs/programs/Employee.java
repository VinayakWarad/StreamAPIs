package com.example.StreamAPIs.programs;

public class Employee {
    private String name;
    private int age;
    private String dept;

    // Constructor
    public Employee(String name, int age, String dept) {
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDept() {
        return dept;
    }

    // toString() for easy printing
    @Override
    public String toString() {
        return name + " (" + age + ") - " + dept;
    }
}
