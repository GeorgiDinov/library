package com.georgidinov.bootstrap;

import com.georgidinov.domain.person.BookAuthor;
import com.georgidinov.domain.person.LibraryReader;
import com.georgidinov.domain.person.Person;
import com.georgidinov.repository.PersonRepositoryMapImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.georgidinov.domain.person.Gender.FEMALE;
import static com.georgidinov.domain.person.Gender.MALE;

public class PersonLoader {

    private static List<Person> personList = new ArrayList<>();

    public static void load(PersonRepositoryMapImpl personRepository) {
        for (Person person : personList) {
            personRepository.add(person);
        }
    }

    static {
        //library male readers
        Person ivan = new LibraryReader("Ivan", "Ivanov", 25, MALE);
        personList.add(ivan);
        Person dragan = new LibraryReader("Dragan", "Tsankov", 22, MALE);
        personList.add(dragan);
        Person petar = new LibraryReader("Petar", "Petrov", 28, MALE);
        personList.add(petar);
        Person petar1 = new LibraryReader("Petar", "Pavlov", 27, MALE);
        personList.add(petar1);

        //library female readers
        Person gergana = new LibraryReader("Gergana", "Danailova", 23, FEMALE);
        personList.add(gergana);
        Person lili = new LibraryReader("Lili", "Ivanova", 80, FEMALE);
        personList.add(lili);
        Person mariq = new LibraryReader("Mariq", "Petrova", 25, FEMALE);
        personList.add(mariq);
        Person hristina = new LibraryReader("Hristina", "Petrova", 22, FEMALE);
        personList.add(hristina);

        //authors
        BookAuthor bookAuthor1 = new BookAuthor("John", "Doe", LocalDate.of(1980, 10, 5), null, "USA");
        personList.add(bookAuthor1);
        BookAuthor bookAuthor2 = new BookAuthor("Jane", "Dope", LocalDate.of(1985, 9, 6), null, "USA");
        personList.add(bookAuthor2);
        BookAuthor bookAuthor3 = new BookAuthor("Jimmy", "Hendricks", LocalDate.of(1950, 10, 5), LocalDate.of(1980, 5, 10), "USA");
        personList.add(bookAuthor3);
        BookAuthor bookAuthor4 = new BookAuthor("Dimitar", "Talev", LocalDate.of(1915, 10, 5), LocalDate.of(1960, 6, 15), "Bulgaria");
        personList.add(bookAuthor4);
        BookAuthor bookAuthor5 = new BookAuthor("Dan", "White", LocalDate.of(1980, 10, 5), null, "USA");
        personList.add(bookAuthor5);
        BookAuthor bookAuthor6 = new BookAuthor("James", "Gosling", LocalDate.of(1960, 9, 6), null, "USA");
        personList.add(bookAuthor6);
        BookAuthor bookAuthor7 = new BookAuthor("Richy", "Blakemore", LocalDate.of(1945, 2, 9), null, "USA");
        personList.add(bookAuthor7);
        BookAuthor bookAuthor8 = new BookAuthor("Pattern", "Matching", LocalDate.of(1969, 4, 17), LocalDate.now(), "USA");
        personList.add(bookAuthor8);
        BookAuthor bookAuthor9 = new BookAuthor("Iron", "MikeTyson", LocalDate.of(1956, 12, 19), null, "USA");
        personList.add(bookAuthor9);
        BookAuthor bookAuthor10 = new BookAuthor("Glen", "Morrison", LocalDate.of(1956, 7, 14), null, "USA");
        personList.add(bookAuthor10);
        BookAuthor bookAuthor11 = new BookAuthor("Heavy", "Metal", LocalDate.of(1970, 12, 12), null, "USA");
        personList.add(bookAuthor11);
        BookAuthor bookAuthor12 = new BookAuthor("Captain", "America", LocalDate.of(1958, 3, 3), null, "USA");
        personList.add(bookAuthor12);
        BookAuthor bookAuthor13 = new BookAuthor("First", "Avenger", LocalDate.of(1972, 5, 9), null, "Mars");
        personList.add(bookAuthor13);

    }//end of SIB

}
