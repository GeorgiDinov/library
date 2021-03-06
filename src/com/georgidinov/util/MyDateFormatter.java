package com.georgidinov.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Utility class to output LocalDate objects in String format
 */
public final class MyDateFormatter {

    private MyDateFormatter() {
    }

    public static String getDateString(LocalDate date) {
        if (date != null) {
            return DateTimeFormatter.ofPattern("dd.MM.yyyy").format(date);
        }
        return "dd.MM.yyyy";
    }
}
