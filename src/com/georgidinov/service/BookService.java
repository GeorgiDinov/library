package com.georgidinov.service;

import com.georgidinov.repository.BookRepositoryMapImpl;

//todo implement logic
public class BookService {

    private BookRepositoryMapImpl bookRepository;

    public BookService(BookRepositoryMapImpl bookRepository) {
        this.bookRepository = bookRepository;
    }

}
