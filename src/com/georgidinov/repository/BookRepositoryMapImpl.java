package com.georgidinov.repository;

import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.book.EDownloadable;
import com.georgidinov.domain.book.EReadable;
import com.georgidinov.domain.book.PaperBook;
import com.georgidinov.domain.person.BookAuthor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class BookRepositoryMapImpl {

    private Map<Integer, Book> bookMap = new HashMap<>();


    public void addBook(Book book) {
        this.bookMap.put(book.getId(), book);
    }

    public Set<Book> findAll() {
        return new HashSet<>(this.bookMap.values());
    }

    public Optional<Book> findBookById(int id) {
        return Optional.of(this.bookMap.get(id));
    }

    public Optional<Book> findBookByTitle(String title) {
        return this.bookMap.values()
                .stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst();
    }

    public Set<Book> findAllByAuthorFirstName(String authorFirstName) {
        Set<Book> books = new HashSet<>();
        for (Book book : this.bookMap.values()) {
            if (book.getAuthors()
                    .stream()
                    .anyMatch(author -> author.getFirstName().equals(authorFirstName))) {
                books.add(book);
            }
        }
        return books;
    }

    public Set<Book> findAllByAuthorLastName(String authorLastName) {
        Set<Book> books = new HashSet<>();
        for (Book book : this.bookMap.values()) {
            if (book.getAuthors()
                    .stream()
                    .anyMatch(author -> author.getLastName().equals(authorLastName))) {
                books.add(book);
            }
        }
        return books;
    }

    public Set<Book> findAllPaperBooks() {
        Set<Book> paperBooks = new HashSet<>();
        this.bookMap.values().forEach(book -> {
            if (book instanceof PaperBook) {
                paperBooks.add(book);
            }
        });
        return paperBooks;
    }

    public Set<Book> findAllEReadableBooks() {
        Set<Book> eBooks = new HashSet<>();
        this.bookMap.values().forEach(book -> {
            if (book instanceof EReadable) {
                eBooks.add(book);
            }
        });
        return eBooks;
    }

    public Set<Book> findAllEDownloadableBooks() {
        Set<Book> eDownloadableBooks = new HashSet<>();
        this.bookMap.values().forEach(book -> {
            if (book instanceof EDownloadable) {
                eDownloadableBooks.add(book);
            }
        });
        return eDownloadableBooks;
    }

    private Set<BookAuthor> getAllAuthors() {
        Set<BookAuthor> authors = new HashSet<>();
        for (Book book : this.bookMap.values()) {
            authors.addAll(book.getAuthors());
        }
        return authors;
    }

}
