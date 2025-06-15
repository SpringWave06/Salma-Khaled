package com.pioneers.service.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class StudentSignUpDto {
    @NotBlank(message = "Name Cannot be null or blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;
    @Email(message = "Email should be valid")
    private String email;
    @Min(value = 18, message = "Age must be at least 18 years old")
    @Max(value = 23, message = "Age must be no more that 23 years old")
    private int age;
    @Pattern(regexp = "^\\+201[0-2,5]\\d{8}$", message = "Phone number is not an Egyptian number")
    private String phone;
    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{9,}$", message = "Password in invalid")
    private String password;
}
