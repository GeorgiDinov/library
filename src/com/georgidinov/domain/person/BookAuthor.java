package com.georgidinov.domain.person;

import java.time.LocalDate;

import static com.georgidinov.util.MyMessages.DATE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.NATIONALITY;
import static com.georgidinov.util.MyMessages.SPACE;
import static com.georgidinov.util.Validator.isValidString;

public class BookAuthor extends Person {

    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String nationality;

    public BookAuthor(String firstName, String lastName,
                      LocalDate dateOfBirth, LocalDate dateOfDeath, String nationality) {
        super(firstName, lastName);
        this.dateOfBirth = validateDate(dateOfBirth);
        this.dateOfDeath = dateOfDeath;
        this.nationality = this.validateNationality(nationality);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public String getNationality() {
        return nationality;
    }

    private LocalDate validateDate(LocalDate date) {
        if (date != null && !date.isAfter(LocalDate.now())) {
            return date;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + DATE);
    }

    private String validateNationality(String nationality) {
        if (isValidString(nationality)) {
            return nationality;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + NATIONALITY);
    }

}
