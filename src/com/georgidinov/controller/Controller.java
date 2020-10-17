package com.georgidinov.controller;

import com.georgidinov.repository.BookRepository;
import com.georgidinov.repository.BorrowRecordRepository;
import com.georgidinov.repository.BorrowRequestRepository;
import com.georgidinov.repository.PersonRepository;


//test class for the overall logic
//todo replace persistence layer with service layer if successful
public class Controller {

    private BookRepository bookRepository;
    private PersonRepository personRepository;
    private BorrowRecordRepository borrowRecordRepository;
    private BorrowRequestRepository borrowRequestRepository;

    public Controller(BookRepository bookRepository,
                      PersonRepository personRepository,
                      BorrowRecordRepository borrowRecordRepository,
                      BorrowRequestRepository borrowRequestRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
        this.borrowRecordRepository = borrowRecordRepository;
        this.borrowRequestRepository = borrowRequestRepository;
    }


}
