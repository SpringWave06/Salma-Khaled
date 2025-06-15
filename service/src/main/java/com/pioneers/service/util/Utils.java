package com.pioneers.service.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

/**
 * Random Utilities methods.
 *
 * @author Abdelaziz Said
 */
@UtilityClass
public class Utils {

    public static String generateRandomUuid() {
        return UUID.randomUUID().toString();
    }

    public static int incrementAgeByYear(final int age) {
        return age + 1;
    }
}
