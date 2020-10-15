package com.georgidinov.domain.person;

import java.time.LocalDate;

import static com.georgidinov.util.MyDateFormatter.getDateString;
import static com.georgidinov.util.MyMessages.DATE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static com.georgidinov.util.Validator.validateStringField;

public class BookAuthor extends Person {

    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String nationality;

    public BookAuthor(String firstName, String lastName, LocalDate dateOfBirth, String nationality) {
        this(firstName, lastName, dateOfBirth, null, nationality);
    }

    public BookAuthor(String firstName, String lastName,
                      LocalDate dateOfBirth, LocalDate dateOfDeath, String nationality) {
        super(firstName, lastName);
        this.dateOfBirth = validateDate(dateOfBirth);
        this.dateOfDeath = dateOfDeath;
        this.nationality = validateStringField(nationality);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfBirthString() {
        return getDateString(dateOfBirth);
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public String getDateOfDeathString() {
        return getDateString(dateOfDeath);
    }

    public String getNationality() {
        return nationality;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    private LocalDate validateDate(LocalDate date) {
        if (date != null && !date.isAfter(LocalDate.now())) {
            return date;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + DATE);
    }

}
