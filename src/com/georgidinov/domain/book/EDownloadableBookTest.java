package com.georgidinov.domain.book;

import com.georgidinov.bootstrap.BookLoader;
import com.georgidinov.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.georgidinov.util.MyMessages.THE_LINK_TO_DOWNLOAD_IT;
import static com.georgidinov.util.MyMessages.THE_LINK_TO_READ_IT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EDownloadableBookTest {

    BookRepository bookRepository;
    List<Book> eDownloadableBooks;
    EDownloadableBook book;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        BookLoader.load(bookRepository);
        eDownloadableBooks = new ArrayList<>(bookRepository.findAllEDownloadableBooks());
    }

    @Test
    void getLinkToPreview() {
        //given
        book = (EDownloadableBook) eDownloadableBooks.get(0);

        //when
        String link = book.getLinkToPreview();

        //then
        assertEquals(THE_LINK_TO_READ_IT, link);
    }

    @Test
    void getLinkToDownload() {
        //given
        book = (EDownloadableBook) eDownloadableBooks.get(0);

        //when
        String link = book.getLinkToDownload();

        //then
        assertEquals(THE_LINK_TO_DOWNLOAD_IT, link);
    }
}