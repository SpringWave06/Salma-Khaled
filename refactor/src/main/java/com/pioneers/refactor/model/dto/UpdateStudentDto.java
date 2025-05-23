package com.pioneers.refactor.model.dto;

import lombok.Data;

@Data
public class UpdateStudentDto {
    private String name;
    private String email;
    private int age;
    private String address;
    private String password;
}
