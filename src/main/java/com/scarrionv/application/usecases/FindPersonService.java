package com.scarrionv.application.usecases;

import com.scarrionv.domain.Person;
import com.scarrionv.ports.outbound.PeopleRepository;
import jakarta.inject.Singleton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Singleton
public class FindPersonService {
    private final PeopleRepository peopleRepository;

    public FindPersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Mono<Optional<Person>> findById(Long id) {
        return peopleRepository.findById(Mono.just(id));
    }

    public Flux<Person> findAll() {
        return peopleRepository.findAll();
    }
}
