package com.pioneers.refactor.model.dto;

import lombok.*;

@Data
//@ToString(onlyExplicitlyIncluded = true)
//@ToString
//@ToString(of = {"firstName", "lastName"})
@ToString(exclude = {"phone", "age"})
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
//    @ToString.Include
    @NonNull
    private String firstName;
//    @ToString.Include
    @NonNull
    private String lastName;
//    @ToString.Include
    private String email;
//    @ToString.Exclude
    private String phone;
    private String gender;
//    @ToString.Exclude
    private int age;
    private String address;

    public Student(@NonNull String firstName, @NonNull String lastName, @NonNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
