package com.pioneers.refactor.model.entity;

import lombok.Data;

@Data
public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
    private String address;
    private String password;
    private boolean isLoggedIn;

    public Student(String id, String name, String email, int age, String address, String password, boolean isLoggedIn) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }
}
