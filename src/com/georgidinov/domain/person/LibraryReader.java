package com.georgidinov.domain.person;

import static com.georgidinov.util.MyMessages.AGE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.SPACE;

public class LibraryReader extends Person {

    private int age;
    private Gender gender;

    public LibraryReader(String firstName, String lastName,
                         int age, Gender gender) {
        super(firstName, lastName);
        this.age = validateAge(age);
        this.gender = gender;
    }

    //todo validations

    private int validateAge(int age) {
        if (age >= 0 && age <= 120) {
            return age;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + AGE);
    }
}
