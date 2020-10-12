package com.georgidinov.domain.person;

public class LibraryReader extends Person {

    private int age;
    private Gender gender;

    public LibraryReader(String firstName, String lastName,
                         int age, Gender gender) {
        super(firstName, lastName);
        this.age = age;
        this.gender = gender;
    }

    //todo validations
}
