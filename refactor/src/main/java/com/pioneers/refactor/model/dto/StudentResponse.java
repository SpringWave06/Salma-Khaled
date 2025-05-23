package com.pioneers.refactor.model.dto;

import lombok.Data;

@Data
public class StudentResponse {
    private String name;
    private String email;
    private int age;
    private String address;

    public StudentResponse(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }
}
