package com.georgidinov.service;

import com.georgidinov.repository.BookRepository;

//todo implement logic
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
