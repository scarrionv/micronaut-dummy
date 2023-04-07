package com.scarrionv.domain;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class PeopleService {
    private Long globalId = 0L;
    private final List<Person> people = new ArrayList<>();

    public Optional<Person> getPerson(Long id) {
        return people.stream().filter(person -> id.equals(person.getId())).findAny();
    }

    public List<Person> getAll() {
        return people;
    }

    public Person create(Person person) {
        person.setId(globalId++);
        people.add(person);
        return person;
    }
}
