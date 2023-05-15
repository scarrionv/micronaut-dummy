package com.scarrionv.application.usecases;

import com.scarrionv.application.annotations.LogAndTrace;
import com.scarrionv.domain.Person;
import com.scarrionv.ports.outbound.PeopleRepository;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

@Singleton
public class CreatePersonService {

    private final PeopleRepository peopleRepository;

    public CreatePersonService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @LogAndTrace
    public Mono<Person> create(Mono<Person> person) {
        return peopleRepository.add(person);
    }
}
