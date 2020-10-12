package com.georgidinov.util;

public final class Validator {

    private Validator() {
    }

    public static boolean isValidString(String stringToValidate) {
        return stringToValidate != null && !stringToValidate.isBlank();
    }

}
