package com.pioneers.service.error.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Errors {
    LOGIN_ERROR("LoginError", "Cannot login with invalid email or password"),
    LOGOUT_ERROR("LogoutError", "Cannot logout because student is not logged in"),
    INVALID_NAME("InvalidName", "Cannot sign up with invalid student name"),
    INVALID_EMAIL("InvalidEmail", "Cannot sign up with invalid email address"),
    STUDENT_REGISTERED("StudentRegistered", "Cannot sign up because student already registered"),
    STUDENT_NOT_REGISTERED("StudentNotRegistered", "Student is not registered in our system");

    private final String message;
    private final String description;
}
