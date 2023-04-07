package com.scarrionv.domain;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import io.micronaut.validation.Validated;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Validated
@Serdeable
public class Person {

    @Nullable
    private Long id;

    @NonNull
    @Size(max = 40)
    private final String name;

    public Person(@NonNull String name) {
        this.name = name;
    }
}
