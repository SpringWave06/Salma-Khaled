package com.pioneers.refactor.model.dto;

public record Employee(String firstName, String lastName, String email, String phone, String gender, String birthDate,
                       float salary) {

    public void printEmployeeInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
