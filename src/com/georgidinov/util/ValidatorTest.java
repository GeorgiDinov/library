package com.georgidinov.util;

import org.junit.jupiter.api.Test;

import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    @Test
    void isValidStringEmptyStringTest() {
        //given
        String emptyString = "";
        //when
        boolean result = Validator.isValidString(emptyString);
        //then
        assertFalse(result);
    }

    @Test
    void isValidStringNullStringTest() {
        //given
        String nullString = null;
        //when
        boolean result = Validator.isValidString(nullString);
        //then
        assertFalse(result);
    }

    @Test
    void isValidStringNotNullNotEmptyStringTest() {
        //given
        String goodString = "Test";
        //when
        boolean result = Validator.isValidString(goodString);
        //then
        assertTrue(result);
    }

    @Test
    void validateStringFieldEmptyStringTest() {
        //given
        String emptyString = "";
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String output = Validator.validateStringField(emptyString);
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + emptyString;
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(exceptionMessage));
    }

    @Test
    void validateStringFieldNullStringTest() {
        //given
        String nullString = null;
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String output = Validator.validateStringField(nullString);
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + nullString;
        String exceptionMessage = exception.getMessage();
        assertTrue(expectedMessage.contains(exceptionMessage));

    }

    @Test
    void validateStringFieldNotNullNotEmptyStringTest() {
        //given
        String passedString = "TestString";
        //when
        String outputtedString = Validator.validateStringField(passedString);
        //then
        assertEquals(passedString, outputtedString);
    }
}