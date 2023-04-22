package com.scarrionv.application;


import com.scarrionv.domain.PeopleService;
import com.scarrionv.domain.Person;
import com.scarrionv.application.annotations.LogMethod;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Slf4j
@Controller("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @LogMethod
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Single<Optional<Person>> getById(@NotNull Long id) {

        Optional<Person> optionalPerson = peopleService.getPerson(id);
        return Single.just(optionalPerson);
    }

    @LogMethod
    @Get(produces = MediaType.APPLICATION_JSON)
    public Flowable<Person> getAll() {

        return Flowable.fromIterable(peopleService.getAll());
    }

    @LogMethod
    @Post
    public Single<Person> create(@Valid @Body Person person) {

        return Single.just(peopleService.create(person));
    }
}
