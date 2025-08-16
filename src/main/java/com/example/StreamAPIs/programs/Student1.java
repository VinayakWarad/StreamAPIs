package com.example.StreamAPIs.programs;

import java.util.List;

public class Student1 {


    private String name;
    private List<String> courses;

    public Student1(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<String> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }
}