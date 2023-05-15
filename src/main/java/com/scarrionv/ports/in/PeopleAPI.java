package com.scarrionv.ports.in;

import com.scarrionv.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface PeopleAPI {

    Mono<Optional<Person>> getById(Long id);

    Flux<Person> getAll();

    Mono<Person> create(Person person);
}
