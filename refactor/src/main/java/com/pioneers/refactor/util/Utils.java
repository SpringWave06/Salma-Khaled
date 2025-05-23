package com.pioneers.refactor.util;

import java.util.UUID;

/**
 * Random Utilities methods.
 *
 * @author Abdelaziz Said
 */
public final class Utils {

    private Utils() {
        throw new IllegalStateException("Utils is a Utility class");
    }

    public static String generateRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public static int increaseAgeByOneYear(final int age) {
        return age + 1;
    }
}
