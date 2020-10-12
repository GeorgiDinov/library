package com.georgidinov.domain.person;

public abstract class Person {

    private static int instanceCounter = 0;

    protected int id;
    protected String firstName;
    protected String lastName;

    public Person(String firstName, String lastName) {
        this.id = ++instanceCounter;
        this.firstName = firstName;
        this.lastName = lastName;
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

    //todo validations
}
