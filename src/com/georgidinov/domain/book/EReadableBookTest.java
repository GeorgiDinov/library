package com.georgidinov.domain.book;

import com.georgidinov.bootstrap.BookLoader;
import com.georgidinov.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.georgidinov.util.MyMessages.THE_LINK_TO_READ_IT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EReadableBookTest {

    BookRepository bookRepository;
    List<Book> eReadableBooks;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        BookLoader.load(bookRepository);
        eReadableBooks = new ArrayList<>(bookRepository.findAllEReadableBooksOnly());
    }

    @Test
    void getLinkToPreview() {
        //given
        EReadableBook eReadableBook = (EReadableBook) eReadableBooks.get(0);

        //when
        String link = eReadableBook.getLinkToPreview();

        //then
        assertEquals(link, THE_LINK_TO_READ_IT);
    }
}