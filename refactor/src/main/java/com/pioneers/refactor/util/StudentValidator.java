package com.pioneers.refactor.util;

import com.pioneers.refactor.model.dto.StudentSignUpDto;

/**
 * Performs all student validation.
 *
 * @author Abdelaziz Said
 */
public final class StudentValidator {

    private StudentValidator() {
        throw new IllegalStateException("StudentValidator is a Utility class");
    }

    public static boolean isNameMatched(String sourceName, String targetName) {
        return sourceName.equalsIgnoreCase(targetName);
    }

    public static boolean isEmailMatched(String sourceEmail, String targetEmail) {
        return sourceEmail.equalsIgnoreCase(targetEmail);
    }

    public static boolean isAgeMatched(int sourceAge, int targetAge) {
        return sourceAge == targetAge;
    }

    public static boolean isPasswordMatched(String sourcePassword, String targetPassword) {
        return sourcePassword.equals(targetPassword);
    }

    public static boolean isNameValidated(final StudentSignUpDto studentSignUpDto) {
        return !studentSignUpDto.getName().isEmpty() && studentSignUpDto.getName().length() >= 2;
    }

    public static boolean isEmailValidated(final StudentSignUpDto studentSignUpDto) {
        return studentSignUpDto.getEmail().contains("@");
    }
}
