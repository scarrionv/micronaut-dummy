package com.scarrionv.ports.outbound;

import com.scarrionv.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface PeopleRepository {
    Mono<Person> add(Mono<Person> person);

    Mono<Optional<Person>> findById(Mono<Long> name);

    Flux<Person> findAll();
}
