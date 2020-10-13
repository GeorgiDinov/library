package com.georgidinov.bootstrap;

import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.book.EDownloadableBook;
import com.georgidinov.domain.book.EReadableBook;
import com.georgidinov.domain.book.PaperBook;
import com.georgidinov.domain.person.BookAuthor;
import com.georgidinov.repository.BookRepositoryMapImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.georgidinov.domain.book.Genre.FANTASY;
import static com.georgidinov.domain.book.Genre.SCIENCE;
import static com.georgidinov.domain.book.Genre.SCIENCE_FICTION;
import static com.georgidinov.domain.book.Genre.WESTERN;
import static com.georgidinov.util.MyMessages.THE_LINK_TO_DOWNLOAD_IT;
import static com.georgidinov.util.MyMessages.THE_LINK_TO_READ_IT;

public class BookLoader {

    private static List<Book> bookList = new ArrayList<>();

    public static void load(BookRepositoryMapImpl bookRepository) {
        for (Book book : bookList) {
            bookRepository.addBook(book);
        }
    }

    static {
        //paper books
        Set<BookAuthor> paperBookAuthors = new HashSet<>();
        paperBookAuthors.add(new BookAuthor("John", "Doe", LocalDate.of(1980, 10, 5), null, "USA"));
        paperBookAuthors.add(new BookAuthor("Jane", "Dope", LocalDate.of(1985, 9, 6), null, "USA"));
        Book book = new PaperBook("PaperBook", "123456789", paperBookAuthors, "About Something", FANTASY, 5);
        bookList.add(book);

        Set<BookAuthor> paperBookAuthors2 = new HashSet<>();
        paperBookAuthors2.add(new BookAuthor("Jimmy", "Hendricks", LocalDate.of(1950, 10, 5), LocalDate.of(1980, 5, 10), "USA"));
        Book book2 = new PaperBook("PaperBookHendricks", "987654321", paperBookAuthors2, "About Something Else", SCIENCE_FICTION, 10);
        bookList.add(book2);

        Set<BookAuthor> paperBookAuthors3 = new HashSet<>();
        paperBookAuthors3.add(new BookAuthor("Dimitar", "Talev", LocalDate.of(1915, 10, 5), LocalDate.of(1960, 6, 15), "Bulgaria"));
        Book book3 = new PaperBook("TheIronLight", "0123456789", paperBookAuthors3, "About Light", WESTERN, 15);
        bookList.add(book3);

        //eReadable books
        Set<BookAuthor> paperBookAuthors4 = new HashSet<>();
        paperBookAuthors4.add(new BookAuthor("Dan", "White", LocalDate.of(1980, 10, 5), null, "USA"));
        paperBookAuthors4.add(new BookAuthor("James", "Gosling", LocalDate.of(1960, 9, 6), null, "USA"));
        Book eBook = new EReadableBook("EReadableBook", "1234567890", paperBookAuthors4, "About Something", FANTASY, THE_LINK_TO_READ_IT);
        bookList.add(eBook);

        Set<BookAuthor> paperBookAuthors5 = new HashSet<>();
        paperBookAuthors5.add(new BookAuthor("Richy", "Blakemore", LocalDate.of(1945, 2, 9), null, "USA"));
        paperBookAuthors5.add(new BookAuthor("Pattern", "Matching", LocalDate.of(1969, 4, 17), LocalDate.now(), "USA"));
        Book eBook2 = new EReadableBook("EBookForJ", "01234567890", paperBookAuthors5, "About Java", SCIENCE, THE_LINK_TO_READ_IT);
        bookList.add(eBook2);

        Set<BookAuthor> paperBookAuthors6 = new HashSet<>();
        paperBookAuthors6.add(new BookAuthor("Iron", "MikeTyson", LocalDate.of(1956, 12, 19), null, "USA"));
        Book eBook3 = new EReadableBook("StuffForJ", "01234567890", paperBookAuthors6, "About Something Strange With Java", SCIENCE, THE_LINK_TO_READ_IT);
        bookList.add(eBook3);

        //eDownloadable books
        Set<BookAuthor> paperBookAuthors7 = new HashSet<>();
        paperBookAuthors7.add(new BookAuthor("Glen", "Morrison", LocalDate.of(1956, 7, 14), null, "USA"));
        Book eDownloadableBook = new EDownloadableBook("WTForJ", "01234567890", paperBookAuthors7, "About Something Strange With Java", SCIENCE, THE_LINK_TO_READ_IT, THE_LINK_TO_DOWNLOAD_IT);
        bookList.add(eDownloadableBook);

        Set<BookAuthor> paperBookAuthors8 = new HashSet<>();
        paperBookAuthors8.add(new BookAuthor("Heavy", "Metal", LocalDate.of(1970, 12, 12), null, "USA"));
        Book eDownloadableBook1 = new EDownloadableBook("ColorForJ", "01234567890", paperBookAuthors8, "About Something Brown And Java", WESTERN, THE_LINK_TO_READ_IT, THE_LINK_TO_DOWNLOAD_IT);
        bookList.add(eDownloadableBook1);

        Set<BookAuthor> paperBookAuthors9 = new HashSet<>();
        paperBookAuthors9.add(new BookAuthor("Captain", "America", LocalDate.of(1958, 3, 3), null, "USA"));
        paperBookAuthors9.add(new BookAuthor("First", "Avenger", LocalDate.of(1972, 5, 9), null, "Mars"));
        Book eDownloadableBook2 = new EDownloadableBook("HeavyWTForJ", "01234567890", paperBookAuthors9, "About Something Heavy And Java", SCIENCE_FICTION, THE_LINK_TO_READ_IT, THE_LINK_TO_DOWNLOAD_IT);
        bookList.add(eDownloadableBook2);
    }//end of SIB

}
