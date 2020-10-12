package com.georgidinov.domain.person;

import java.time.LocalDate;

public class BookAuthor extends Person {

    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String nationality;

    public BookAuthor(String firstName, String lastName,
                      LocalDate dateOfBirth, LocalDate dateOfDeath, String nationality) {
        super(firstName, lastName);
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.nationality = nationality;
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
    //todo validations
}
