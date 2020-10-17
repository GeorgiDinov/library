package com.georgidinov.service;

import com.georgidinov.repository.PersonRepository;

//todo implement logic
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

}
