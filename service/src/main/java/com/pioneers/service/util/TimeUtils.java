package com.pioneers.service.util;

import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.time.Instant;

/**
 * Performs all time utilities.
 *
 * @author Abdelaziz Said
 */
@UtilityClass
public class TimeUtils {

    /**
     * Calculates the current timestamp.
     *
     * @return Current timestamp.
     */
    public static Timestamp currentTimestamp() {
        return Timestamp.from(Instant.now());
    }
}
