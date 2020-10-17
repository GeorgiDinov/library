package com.georgidinov.domain.person;

import static com.georgidinov.util.Validator.validateStringField;

public abstract class Person {

    private static int instanceCounter = 0;
    private int id;

    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = validateStringField(firstName);
        this.lastName = validateStringField(lastName);
        this.id = ++instanceCounter;
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
