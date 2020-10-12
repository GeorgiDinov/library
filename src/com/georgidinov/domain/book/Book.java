package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

public class Book {

    private static int instanceCounter = 0;

    private int id;
    private String title;
    private String isbn;
    private Set<BookAuthor> authors;
    private String summary;
    private Genre genre;
    private int quantity;

}
