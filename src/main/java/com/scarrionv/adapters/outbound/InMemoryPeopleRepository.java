package com.scarrionv.adapters.outbound;

import com.scarrionv.domain.Person;
import com.scarrionv.ports.outbound.PeopleRepository;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Singleton
public class InMemoryPeopleRepository implements PeopleRepository {

    private Long globalId = 0L;
    private final List<Person> people = new ArrayList<>();

    @Override
    public Mono<Person> add(Mono<Person> personMono) {
        return personMono.map(this::add);
    }

    private Person add(Person person) {
        person.setId(globalId++);
        people.add(person);
        return person;
    }

    @Override
    public Mono<Optional<Person>> findById(Mono<Long> idMono) {
        return idMono.map(this::findById);
    }

    private Optional<Person> findById(Long id) {
        return people.stream()
                .filter(person -> id.equals(person.getId()))
                .findAny();
    }

    @Override
    public Flux<Person> findAll() {
        return Flux.fromStream(people.stream());
    }

}
