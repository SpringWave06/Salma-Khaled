package com.pioneers.service.util;

import lombok.experimental.UtilityClass;

/**
 * Performs all student validation.
 *
 * @author Abdelaziz Said
 */
@UtilityClass
public class StudentValidator {

    public static boolean isNameMatched(final String sourceName, final String targetName) {
        return sourceName.equalsIgnoreCase(targetName);
    }

    public static boolean isEmailMatched(final String sourceEmail, final String targetEmail) {
        return sourceEmail.equalsIgnoreCase(targetEmail);
    }

    public static boolean isAgeMatched(final int sourceAge, final int targetAge) {
        return sourceAge == targetAge;
    }

    public static boolean isPasswordMatched(final String sourcePassword, final String targetPassword) {
        return sourcePassword.equals(targetPassword);
    }

    public static boolean isNameValidated(final String name) {
        return name.length() >= 2;
    }

    public static boolean isEmailValidated(final String email) {
        return email.contains("@");
    }
}
