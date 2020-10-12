package com.georgidinov.repository;

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
                .filter(person -> person.getFirstName().equals(lastName))
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
            if (person.getFirstName().equals(lastName)) {
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

}
