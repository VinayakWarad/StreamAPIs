package com.example.StreamAPIs.programs.flatMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*✅ Example: Nested Custom Objects
If your custom object contains another object, you can still use flatMap. Here’s a more complex case:*/

public class flatMapExamples {

    public static void main(String[] args) {
        // List<Department> departments
        List<Dept> departments = Arrays.asList(
                new Dept("Computer Science", Arrays.asList(
                        new Stdnt("Alice"), new Stdnt("Bob"))),
                new Dept("Mathematics", Arrays.asList(
                        new Stdnt("Charlie"), new Stdnt("Diana")))
        );

        List<String> allStudentNames = departments.stream()
                .flatMap(dept -> dept.getStudents().stream())
                .map(Stdnt::getName)
                .collect(Collectors.toList());

        System.out.println(allStudentNames); // Output: [Alice, Bob, Charlie, Diana]
    }
}


class Stdnt {
    private String name;

    public Stdnt(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Dept {
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Stdnt> getStudents() {
        return students;
    }

    public void setStudents(List<Stdnt> students) {
        this.students = students;
    }

    public Dept(String deptName, List<Stdnt> students) {
        this.deptName = deptName;
        this.students = students;
    }

    private String deptName;
    private List<Stdnt> students;

}






