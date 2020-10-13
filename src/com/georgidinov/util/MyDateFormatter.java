package com.georgidinov.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class MyDateFormatter {

    private MyDateFormatter() {
    }

    public static String getDateString(LocalDate date) {
        if (date != null) {
            return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date);
        }
        return "yyyy-MM-dd";
    }
}
