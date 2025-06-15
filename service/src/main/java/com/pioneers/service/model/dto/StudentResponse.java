package com.pioneers.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentResponse {
    private String name;
    private String email;
    private int age;
    private String address;
}
