package com.georgidinov.domain.person;

import org.junit.jupiter.api.Test;

import static com.georgidinov.domain.person.Gender.FEMALE;
import static com.georgidinov.domain.person.Gender.MALE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryReaderTest {

    @Test
    void createLibraryReaderFailureBecauseAgeFieldISNegative() {
        //given
        int age = -1;
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LibraryReader reader = new LibraryReader("Library", "Reader", age, MALE);
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + age;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void createLibraryReaderFailureBecauseAgeFieldISOutOfUpperBoundary() {
        //given
        int age = 130;
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LibraryReader reader = new LibraryReader("Library", "Reader", age, MALE);
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + age;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void createLibraryReaderFailureBecauseGenderFieldIsNull() {
        //given
        Gender nullGender = null;
        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LibraryReader reader = new LibraryReader("Null", "GenderReader", 20, nullGender);
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + nullGender;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getAge() {
        //given
        int age = 20;
        LibraryReader reader = new LibraryReader("Test", "Reader", age, MALE);
        //when
        int receivedAge = reader.getAge();
        //then
        assertEquals(age, receivedAge);
    }

    @Test
    void getGender() {
        //given
        Gender femaleGender = FEMALE;
        LibraryReader femaleReader = new LibraryReader("Female", "Reader", 22, femaleGender);
        //when
        Gender receivedGender = femaleReader.getGender();
        boolean areEqual = receivedGender == femaleGender;
        //then
        assertTrue(areEqual);
    }
}