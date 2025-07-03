package com.pioneers.jpa.model.dto;

import jakarta.validation.constraints.*;

import java.util.Date;

public record StudentDto(
        @NotBlank(message = "First Name Cannot be null or blank")
        @Size(min = 2, max = 50, message = "First Name must be between 2 and 50 characters")
        String firstName,
        @NotBlank(message = "Second Name Cannot be null or blank")
        @Size(min = 2, max = 50, message = "Second Name must be between 2 and 50 characters")
        String secondName,
        @Email(message = "Email should be valid")
        String email,
        @Pattern(regexp = "^\\+201[0-2,5]\\d{8}$", message = "Phone number is not an Egyptian number")
        String phone,
        Date enrolmentDate,
        @Min(value = 0, message = "Degree cannot be less than 0")
        @Max(value = 100, message = "Degree cannot be more than 100")
        Float degree,
        @Pattern(regexp = "^(male|female)$", message = "Gender must be male or female only")
        String gender
) {
}
