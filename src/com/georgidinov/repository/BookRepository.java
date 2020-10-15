package com.georgidinov.repository;

import com.georgidinov.bootstrap.BookLoader;
import com.georgidinov.domain.book.Book;
import com.georgidinov.domain.book.EDownloadable;
import com.georgidinov.domain.book.EReadable;
import com.georgidinov.domain.book.Genre;
import com.georgidinov.domain.book.PaperBook;
import com.georgidinov.domain.person.BookAuthor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public final class BookRepository {

    private Map<Integer, Book> bookMap = new HashMap<>();

    public void addBook(Book book) {
        this.bookMap.put(book.getId(), book);
    }

    public Set<Book> findAll() {
        return new HashSet<>(this.bookMap.values());
    }

    public Optional<Book> findBookById(int id) {
        return Optional.ofNullable(this.bookMap.get(id));
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

    public Set<Book> findAllByAuthorFullName(String firstName, String lastName) {
        Set<Book> books = new HashSet<>();
        this.bookMap.values().forEach(book -> {
            if (book.getAuthors()
                    .stream()
                    .anyMatch(bookAuthor -> bookAuthor.getFirstName().equals(firstName) &&
                            bookAuthor.getLastName().equals(lastName))) {
                books.add(book);
            }
        });
        return books;
    }

    public Set<Book> findAllByGenre(Genre genre) {
        Set<Book> books = new HashSet<>();
        this.bookMap.values()
                .stream()
                .filter(book -> book.getGenre() == genre)
                .forEach(books::add);
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

    public Set<Book> findAllEReadableBooksOnly() {
        Set<Book> eReadable = findAllEReadableBooks();
        Set<Book> eDownloadable = findAllEDownloadableBooks();
        eReadable.removeAll(eDownloadable);
        return eReadable;
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

//    public Set<Book> findAllEDownloadableBooksOnly() {
//
//    }

    public Set<BookAuthor> findAllAuthors() {
        Set<BookAuthor> authors = new HashSet<>();
        for (Book book : this.bookMap.values()) {
            authors.addAll(book.getAuthors());
        }
        return authors;
    }

    public int size() {
        return this.bookMap.size();
    }

    //for testing purposes
    public static void main(String[] args) {


        BookRepository bookRepository = new BookRepository();
        BookLoader.load(bookRepository);

        bookRepository.findAllEReadableBooksOnly().forEach(System.out::println);
        bookRepository.findAllEDownloadableBooks().forEach(System.out::println);

//        System.out.println("Total Books Available = " + bookRepository.size());
//        Set<Book> allBooks = bookRepository.findAll();
//        System.out.println("All books size = " + allBooks.size());
//        Set<Book> paperBooks = bookRepository.findAllPaperBooks();
//        Set<Book> eReadableBooks = bookRepository.findAllEReadableBooks();
//        Set<Book> eDownloadableBooks = bookRepository.findAllEDownloadableBooks();
//
//        System.out.println("Paper Books Total = " + paperBooks.size());
//        paperBooks.forEach(System.out::println);
//        System.out.println();
//        System.out.println("EReadable Books Total = " + eReadableBooks.size());
//        eReadableBooks.forEach(System.out::println);
//        System.out.println();
//        System.out.println("EDownloadable Books Total = " + eDownloadableBooks.size());
//        eDownloadableBooks.forEach(System.out::println);
//        System.out.println();
//        Set<BookAuthor> allAuthors = bookRepository.findAllAuthors();
//        System.out.println("All authors size = " + allAuthors.size());
//
//        Set<Book> byAuthorFirstName = bookRepository.findAllByAuthorFirstName("John");
//        Set<Book> byAuthorLastName = bookRepository.findAllByAuthorLastName("Doe");
//        System.out.println("All from John ");
//        byAuthorFirstName.forEach(System.out::println);
//        System.out.println("All from Doe");
//        byAuthorLastName.forEach(System.out::println);
//
//        System.out.println("Book by title WTForJ " + bookRepository.findBookByTitle("WTForJ").get());
//        System.out.println("Book with id = 4 " + bookRepository.findBookById(4).get());
//
//        Set<Book> byGenre = bookRepository.findAllByGenre(SCIENCE);
//        System.out.println("\nAll with genre SCIENCE:");
//        byGenre.forEach(System.out::println);

    }//end of main method

}
