package com.georgidinov.service;

import com.georgidinov.repository.PersonRepositoryMapImpl;

//todo implement logic
public class PersonService {

    private PersonRepositoryMapImpl personRepository;

    public PersonService(PersonRepositoryMapImpl personRepository) {
        this.personRepository = personRepository;
    }

}
