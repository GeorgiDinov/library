package com.georgidinov.domain.person;

import com.georgidinov.bootstrap.PersonLoader;
import com.georgidinov.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        personRepository = new PersonRepository();
        PersonLoader.load(personRepository);
    }

    @Test
    void testEachPersonHasUniqueId() {
        //given
        Set<Person> allPersons = personRepository.findAll();
        Set<Integer> allPersonsIdValues = new HashSet<>();
        allPersons.forEach(person -> allPersonsIdValues.add(person.getId()));

        //when
        int allPersonsSize = allPersons.size();
        int allPersonsIdValuesSize = allPersonsIdValues.size();

        //then
        assertEquals(allPersonsSize, allPersonsIdValuesSize);
    }

}