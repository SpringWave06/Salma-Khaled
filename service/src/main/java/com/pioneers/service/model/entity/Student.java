package com.pioneers.service.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Student {
    private String id;
    private String name;
    private String email;
    private int age;
    private String address;
    private String password;
    private boolean isLoggedIn;
}
