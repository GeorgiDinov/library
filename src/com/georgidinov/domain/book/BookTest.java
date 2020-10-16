package com.georgidinov.domain.book;

import com.georgidinov.bootstrap.BookLoader;
import com.georgidinov.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        BookLoader.load(bookRepository);
    }

    @Test
    void testEachBookHasUniqueId() {
        //given
        Set<Book> allBooks = bookRepository.findAll();
        Set<Integer> allBooksIdValues = new HashSet<>();
        allBooks.forEach(book -> allBooksIdValues.add(book.getId()));

        //when
        int allBooksSize = allBooks.size();
        int allBooksIdValuesSize = allBooksIdValues.size();

        //then
        assertEquals(allBooksSize, allBooksIdValuesSize);
    }

}