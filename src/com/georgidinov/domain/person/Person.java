package com.georgidinov.domain.person;

import static com.georgidinov.util.MyMessages.FIRST_NAME;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyMessages.LAST_NAME;
import static com.georgidinov.util.MyMessages.SPACE;
import static com.georgidinov.util.Validator.isValidString;

public abstract class Person {

    private static int instanceCounter = 0;
    private int id;

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.id = ++instanceCounter;
        this.firstName = this.validateFirstName(firstName);
        this.lastName = this.validateLastName(lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private String validateFirstName(String firstName) {
        if (isValidString(firstName)) {
            return firstName;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + FIRST_NAME);
    }

    private String validateLastName(String lastName) {
        if (isValidString(lastName)) {
            return lastName;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + LAST_NAME);
    }

    //equals and hashCode
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }

        Person person = (Person) object;

        if (id != person.id) {
            return false;
        }
        if (!firstName.equals(person.firstName)) {
            return false;
        }
        return lastName.equals(person.lastName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
