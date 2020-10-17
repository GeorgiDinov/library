package com.georgidinov.domain.book;

import com.georgidinov.domain.person.BookAuthor;

import java.util.Set;

import static com.georgidinov.util.MyMessages.AUTHORS;
import static com.georgidinov.util.MyMessages.GENRE;
import static com.georgidinov.util.MyMessages.INVALID_PARAMETER;
import static com.georgidinov.util.MyPunctuation.SPACE;
import static com.georgidinov.util.Validator.validateStringField;

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
        this.title = validateStringField(title);
        this.isbn = validateStringField(isbn);
        this.authors = validateAuthors(authors);
        this.summary = validateStringField(summary);
        this.genre = validateGenre(genre);
        this.id = ++instanceCounter;
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
    private Set<BookAuthor> validateAuthors(Set<BookAuthor> authors) {
        if (authors != null && !authors.isEmpty()) {
            return authors;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + AUTHORS);
    }

    private Genre validateGenre(Genre genre) {
        if (genre != null) {
            return genre;
        }
        throw new IllegalArgumentException(INVALID_PARAMETER + SPACE + GENRE);
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
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                '}';
    }
}
