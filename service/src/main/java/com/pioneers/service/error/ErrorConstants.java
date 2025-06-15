package com.pioneers.service.error;

import lombok.experimental.UtilityClass;

@Deprecated
@UtilityClass
public class ErrorConstants {

    public static final String LOGIN_ERROR = "LoginError";
    public static final String LOGOUT_ERROR = "LogoutError";
    public static final String INVALID_NAME = "InvalidName";
    public static final String INVALID_EMAIL = "InvalidEmail";
    public static final String STUDENT_REGISTERED = "StudentRegistered";

    public static final String LOGIN_DESCRIPTION = "Cannot login with invalid email or password";
    public static final String LOGOUT_DESCRIPTION = "Cannot logout because student is not logged in";
    public static final String INVALID_NAME_DESCRIPTION = "Cannot sign up with invalid student name";
    public static final String INVALID_EMAIL_DESCRIPTION = "Cannot sign up with invalid email address";
    public static final String STUDENT_REGISTERED_DESCRIPTION = "Cannot sign up because student already registered";
}
