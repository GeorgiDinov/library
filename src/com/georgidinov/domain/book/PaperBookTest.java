package com.georgidinov.domain.book;

import com.georgidinov.bootstrap.PersonLoader;
import com.georgidinov.domain.person.BookAuthor;
import com.georgidinov.domain.person.Person;
import com.georgidinov.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static com.georgidinov.domain.book.Genre.FANTASY;
import static com.georgidinov.domain.book.Genre.WESTERN;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PaperBookTest {

    PersonRepository personRepository;
    ArrayList<Person> allBootstrappedAuthors;
    PaperBook paperBook;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepository();
        PersonLoader.load(personRepository);
        allBootstrappedAuthors = new ArrayList<>(personRepository.findAllAuthors());

        Set<BookAuthor> authors = new HashSet<>();
        authors.add((BookAuthor) allBootstrappedAuthors.get(0));
        paperBook = new PaperBook("test", "12345", authors, "alalbala", WESTERN, 5);
    }

    @Test
    void testPaperBookObjectInitializationFailureBecauseOfStringField() {

        //given
        String title = null, isbn = "1234567890", summary = "about this book";
        Genre genre = FANTASY;
        Set<BookAuthor> authors = new HashSet<>();
        authors.add((BookAuthor) allBootstrappedAuthors.get(0));
        authors.add((BookAuthor) allBootstrappedAuthors.get(1));
        int quantity = 5;

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Book paperBook = new PaperBook(title, isbn, authors, summary, genre, quantity);
        });
        String message = INVALID_PARAMETER + SPACE + title;
        String actualMessage = exception.getMessage();

        //then
        assertTrue(message.contains(actualMessage));
    }

    @Test
    void getQuantity() {
        //given

        //when
        int result = paperBook.getQuantity();
        //then
        assertEquals(5, result);
    }

    @Test
    void decrementQuantitySuccessfully() {
        //given

        //when
        paperBook.decrementQuantity();
        //then
        int quantity = 4;
        assertEquals(quantity, paperBook.getQuantity());
    }

    @Test
    void decrementQuantityUnSuccessfully() {
        //given
        Set<BookAuthor> set = new HashSet<>();
        set.add((BookAuthor) allBootstrappedAuthors.get(0));
        PaperBook localPaperBook = new PaperBook("test", "12345", set, "alalbala", WESTERN, 0);
        //when
        boolean result = localPaperBook.decrementQuantity();
        //then
        assertFalse(result);
    }

    @Test
    void hasQuantityInStock() {
        //given

        //when
        boolean result = paperBook.hasQuantityInStock();
        //then
        assertTrue(result);
    }

}