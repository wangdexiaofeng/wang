package com.jd.io;

public class Student {
    private  int id;
    private int age;
    private String username;

    public Student(int id, int age, String username) {
        this.id = id;
        this.age = age;
        this.username = username;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
