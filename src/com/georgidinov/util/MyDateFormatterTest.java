package com.georgidinov.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MyDateFormatterTest {

    @Test
    void getDateStringDateNotNull() {
        //given
        LocalDate date = LocalDate.of(1990, 10, 20);
        String expectedResult = "20.10.1990";
        //when
        String result = MyDateFormatter.getDateString(date);
        //then
        assertNotNull(result);
        assertEquals(result, expectedResult);
    }

    @Test
    void getDateStringDateNull() {
        //given
        LocalDate nullDate = null;
        String expectedResult = "dd.MM.yyyy";

        //when
        String result = MyDateFormatter.getDateString(nullDate);

        //then
        assertEquals(result, expectedResult);
    }

}