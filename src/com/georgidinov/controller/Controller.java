package com.georgidinov.controller;

import com.georgidinov.repository.BookRepositoryMapImpl;
import com.georgidinov.repository.PersonRepositoryMapImpl;
import com.georgidinov.repository.RecordRepositoryMapImpl;

//todo replace persistence layer with service layer if successful
public class Controller {

    private BookRepositoryMapImpl bookRepository;
    private PersonRepositoryMapImpl personRepository;
    private RecordRepositoryMapImpl recordRepository;

    public Controller(BookRepositoryMapImpl bookRepository,
                      PersonRepositoryMapImpl personRepository,
                      RecordRepositoryMapImpl recordRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.recordRepository = recordRepository;
    }







}
