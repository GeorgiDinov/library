package com.georgidinov.repository;

import com.georgidinov.bootstrap.PersonLoader;
import com.georgidinov.domain.person.BookAuthor;
import com.georgidinov.domain.person.LibraryReader;
import com.georgidinov.domain.person.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class PersonRepositoryMapImpl {

    private Map<Integer, Person> personMap = new HashMap<>();

    public void add(Person person) {
        this.personMap.put(person.getId(), person);
    }

    public Set<Person> findAll() {
        return new HashSet<>(this.personMap.values());
    }

    public Optional<Person> findById(int id) {
        return Optional.of(this.personMap.get(id));
    }

    public Optional<Person> findByFirstName(String firstName) {
        return this.personMap.values()
                .stream()
                .filter(person -> person.getFirstName().equals(firstName))
                .findFirst();
    }

    public Optional<Person> findByLastName(String lastName) {
        return this.personMap.values()
                .stream()
                .filter(person -> person.getLastName().equals(lastName))
                .findFirst();
    }

    public Set<Person> findAllWithFirstName(String firstName) {
        Set<Person> personSet = new HashSet<>();
        for (Person person : this.personMap.values()) {
            if (person.getFirstName().equals(firstName)) {
                personSet.add(person);
            }
        }
        return personSet;
    }

    public Set<Person> findAllWithLastName(String lastName) {
        Set<Person> personSet = new HashSet<>();
        for (Person person : this.personMap.values()) {
            if (person.getLastName().equals(lastName)) {
                personSet.add(person);
            }
        }
        return personSet;
    }

    public Set<Person> findAllAuthors() {
        Set<Person> authors = new HashSet<>();
        for (Person person : this.personMap.values()) {
            if (person instanceof BookAuthor) {
                authors.add(person);
            }
        }
        return authors;
    }

    public Set<Person> findAllReaders() {
        Set<Person> readers = new HashSet<>();
        for (Person person : this.personMap.values()) {
            if (person instanceof LibraryReader) {
                readers.add(person);
            }
        }
        return readers;
    }

    public int size() {
        return this.personMap.size();
    }


    //for testing purposes
    public static void main(String[] args) {

        PersonRepositoryMapImpl personRepository = new PersonRepositoryMapImpl();
        PersonLoader.load(personRepository);

        Set<Person> all = personRepository.findAll();
        System.out.println("All size = " + all.size());
        System.out.println("Print the whole set of persons:");
        all.forEach(System.out::println);
        System.out.println();
        System.out.println("Person with id=3 is " + personRepository.findById(3).get());
        System.out.println("Person with first name Mariq is " + personRepository.findByFirstName("Mariq").get());
        System.out.println("Person with last name Ivanova is " + personRepository.findByLastName("Ivanova").get());

        Set<Person> allWithFirstName = personRepository.findAllWithFirstName("Petar");
        System.out.println("\nAll with first name Petar:");
        allWithFirstName.forEach(System.out::println);

        Set<Person> allWithLastName = personRepository.findAllWithLastName("Petrova");
        System.out.println("\nAll with last name Petrova:");
        allWithLastName.forEach(System.out::println);

        System.out.println();
        Set<Person> allAuthors = personRepository.findAllAuthors();
        System.out.println("The number of authors is " + allAuthors.size());
        System.out.println("All authors: ");
        allAuthors.forEach(System.out::println);

        System.out.println();
        Set<Person> allReaders = personRepository.findAllReaders();
        System.out.println("The number of all readers is " + allReaders.size());
        System.out.println("All readers:");
        allReaders.forEach(System.out::println);

    }

}
