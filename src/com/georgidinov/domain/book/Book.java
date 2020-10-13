package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.MyMessages.*;
import static com.georgidinov.util.Validator.isValidString;

public abstract class Book {

    private static int instanceCounter = 0;
    private int id;

    private String title;
    private String isbn;
    private Set<BookAuthor> authors;
    private String summary;
    private Genre genre;

    protected Book(String title, String isbn, Set<BookAuthor> authors,
                   String summary, Genre genre) {
        this.id = ++instanceCounter;
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.summary = summary;
        this.genre = genre;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Set<BookAuthor> getAuthors() {
        return authors;
    }

    public String getSummary() {
        return summary;
    }

    public Genre getGenre() {
        return genre;
    }

    //validations
    private String validateTitle(String title) {
        if (isValidString(title)) {
            return title;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + TITLE);
    }

    private String validateIsbn(String isbn) {
        if (isValidString(isbn)) {
            return isbn;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + ISBN);
    }

    private Set<BookAuthor> validateAuthors(Set<BookAuthor> authors) {
        if (authors != null && !authors.isEmpty()) {
            return authors;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + AUTHORS);
    }

    private String validateSummary(String summary) {
        if (isValidString(summary)) {
            return summary;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + SUMMARY);
    }

    //equals and hashCode
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Book)) {
            return false;
        }

        Book book = (Book) object;

        if (id != book.id) {
            return false;
        }
        if (!title.equals(book.title)) {
            return false;
        }
        return isbn.equals(book.isbn);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + isbn.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", genre=" + genre +
                '}';
    }
}
