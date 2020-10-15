package com.georgidinov.controller;

import com.georgidinov.repository.BookRepositoryMapImpl;
import com.georgidinov.repository.BorrowRequestRepositoryMapImpl;
import com.georgidinov.repository.PersonRepositoryMapImpl;
import com.georgidinov.repository.RecordRepositoryMapImpl;


//test class for the overall logic
//todo replace persistence layer with service layer if successful
public class Controller {

    private BookRepositoryMapImpl bookRepository;
    private PersonRepositoryMapImpl personRepository;
    private RecordRepositoryMapImpl recordRepository;
    private BorrowRequestRepositoryMapImpl borrowRequestRepository;

    public Controller(BookRepositoryMapImpl bookRepository,
                      PersonRepositoryMapImpl personRepository,
                      RecordRepositoryMapImpl recordRepository,
                      BorrowRequestRepositoryMapImpl borrowRequestRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.recordRepository = recordRepository;
        this.borrowRequestRepository = borrowRequestRepository;
    }


}
