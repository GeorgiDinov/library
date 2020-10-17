package com.georgidinov.domain.person;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.georgidinov.util.MyMessages.DATE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static org.junit.jupiter.api.Assertions.*;

class BookAuthorTest {

    @Test
    void createBookAuthorFailOnNullDateParameter() {
        //given
        LocalDate nullDate = null;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookAuthor bookAuthor = new BookAuthor("Test", "Author", nullDate, "Indian");
        });

        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + DATE;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void createBookAuthorFailOnFutureDateParameter() {
        //given
        LocalDate futureDate = LocalDate.of(2035, 1, 1);

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookAuthor bookAuthor = new BookAuthor("Test", "Author", futureDate, "Indian");
        });

        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + DATE;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void createBookAuthorFailOnStringFieldFirstName() {
        //given
        String emptyFirstName = "";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookAuthor bookAuthor = new BookAuthor(emptyFirstName, "Author", LocalDate.now(), "Indian");
        });
        //then
        String expectedMessage = INVALID_PARAMETER + SPACE + emptyFirstName;
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void getDateOfBirth() {
        //given
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
        BookAuthor bookAuthor = new BookAuthor("Test", "Author", dateOfBirth, "OutOfSpace");

        //when
        LocalDate receivedDateOfBirth = bookAuthor.getDateOfBirth();

        //then
        assertTrue(dateOfBirth.isEqual(receivedDateOfBirth));
    }

    @Test
    void getDateOfBirthString() {
        //given
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
        BookAuthor bookAuthor = new BookAuthor("Test", "Author", dateOfBirth, "OutOfSpace");

        //when
        String dateOfBirthString = bookAuthor.getDateOfBirthString();

        //then
        assertEquals(dateOfBirthString, "01.01.1980");
    }

    @Test
    void getDateOfDeathIfDateOfDateIsInitialized() {
        //given
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
        LocalDate dateOfDead = LocalDate.of(2010, 1, 1);
        BookAuthor deadAuthor = new BookAuthor("Dead", "Author", dateOfBirth, dateOfDead, "FromMars");

        //when
        LocalDate receivedDateOfDead = deadAuthor.getDateOfDeath();

        //then
        assertTrue(receivedDateOfDead.isEqual(dateOfDead));
    }

    @Test
    void getDateOfDeathIfDateOfDateIsNotInitialized() {
        //given
        LocalDate dateOfBirth = LocalDate.of(1980, 1, 1);
        BookAuthor deadAuthor = new BookAuthor("Dead", "Author", dateOfBirth, "FromMars");

        //when
        LocalDate receivedDateOfDead = deadAuthor.getDateOfDeath();

        //then
        assertNull(receivedDateOfDead);
    }

    @Test
    void getDateOfDeathStringIfDateOfDateIsInitializedAndNotNull() {
        //given
        BookAuthor deadAuthor = new BookAuthor("Fully", "Dead", LocalDate.of(1980, 2, 2), LocalDate.of(1999, 3, 5), "Africa");

        //when
        String dateOfDeadString = deadAuthor.getDateOfDeathString();

        //then
        assertEquals(dateOfDeadString, "05.03.1999");
    }

    @Test
    void getDateOfDeathStringIfDateOfDateIsInitializedWithNull() {
        //given
        BookAuthor deadAuthor = new BookAuthor("Fully", "Dead", LocalDate.of(1980, 2, 2), null, "Africa");

        //when
        String dateOfDeadString = deadAuthor.getDateOfDeathString();

        //then
        assertEquals(dateOfDeadString, "dd.MM.yyyy");
    }

    @Test
    void getNationality() {
        //given
        String nationality = "Bulgarian";
        BookAuthor author = new BookAuthor("Another", "FakeAuthor", LocalDate.of(1908, 1, 1), nationality);

        //when
        String receivedNationality = author.getNationality();

        //then
        assertEquals(nationality, receivedNationality);
    }

    @Test
    void setDateOfDeathIfDateNotNull() {
        //given
        LocalDate dateOfDeath = LocalDate.of(1970, 1, 1);
        BookAuthor completelyDead =
                new BookAuthor("Dead", "AsFishInTheSand", LocalDate.of(1900, 1, 1), dateOfDeath, "Papua New Ginny");

        //when
        LocalDate newDateOfDate = LocalDate.now();
        completelyDead.setDateOfDeath(newDateOfDate);

        //then
        assertFalse(completelyDead.getDateOfDeath().isEqual(newDateOfDate));
    }

    @Test
    void setDateOfDeathIfDateIsNull() {
        //given
        BookAuthor completelyDead =
                new BookAuthor("Dead", "AsFishInTheSand", LocalDate.of(1900, 1, 1), "Papua New Ginny");

        //when
        LocalDate newDateOfDate = LocalDate.now();
        completelyDead.setDateOfDeath(newDateOfDate);

        //then
        assertTrue(completelyDead.getDateOfDeath().isEqual(newDateOfDate));
    }
    
}