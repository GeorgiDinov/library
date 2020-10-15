package com.georgidinov.util;

import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;

/**
 * Utility class for general purpose String field validation
 */
public final class Validator {

    private Validator() {
    }

    public static boolean isValidString(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isBlank();
    }

    public static String validateStringField(String stringFiled) {
        if (isValidString(stringFiled)) {
            return stringFiled;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + stringFiled);
    }

}
