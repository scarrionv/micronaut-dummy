package com.scarrionv.adapters.in;


import com.scarrionv.application.annotations.LogAndTrace;
import com.scarrionv.application.usecases.CreatePersonService;
import com.scarrionv.application.usecases.FindPersonService;
import com.scarrionv.domain.Person;
import com.scarrionv.ports.in.PeopleAPI;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Slf4j
@Controller("/people")
public class PeopleController implements PeopleAPI {

    private final CreatePersonService createPersonService;
    private final FindPersonService findPersonService;

    public PeopleController(CreatePersonService createPersonService, FindPersonService findPersonService) {
        this.createPersonService = createPersonService;
        this.findPersonService = findPersonService;
    }

    @LogAndTrace(metrics = true)
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    @Override
    public Mono<Optional<Person>> getById(@NotNull Long id) {

        return findPersonService.findById(id);
    }

    @LogAndTrace(metrics = true)
    @Get(produces = MediaType.APPLICATION_JSON)
    @Override
    public Flux<Person> getAll() {

        return findPersonService.findAll();
    }

    @LogAndTrace(metrics = true)
    @Post
    @Override
    public Mono<Person> create(@Valid @Body Person person) {

        return createPersonService.create(Mono.just(person));
    }
}
