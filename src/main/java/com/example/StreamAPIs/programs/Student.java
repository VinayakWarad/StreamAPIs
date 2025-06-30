package com.example.StreamAPIs.programs;

public class Student {
    private String name;
    private int age;
    private long phoneNum;

    public Student() {
    }

    public Student(String name,int age,  long phoneNum) {
        this.age = age;
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }


}
