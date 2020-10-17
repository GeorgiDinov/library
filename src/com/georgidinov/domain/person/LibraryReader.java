package com.georgidinov.domain.person;

import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;

public class LibraryReader extends Person {

    private int age;
    private Gender gender;

    public LibraryReader(String firstName, String lastName,
                         int age, Gender gender) {
        super(firstName, lastName);
        this.age = validateAge(age);
        this.gender = validateGender(gender);
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    private int validateAge(int age) {
        if (age >= 0 && age <= 120) {
            return age;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + age);
    }

    private Gender validateGender(Gender gender) {
        if (gender != null) {
            return gender;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + gender);
    }

}
