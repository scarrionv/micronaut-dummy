package com.scarrionv.application.annotations;

import com.scarrionv.infraestructure.logging.LogMethodInterceptor;
import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Around()
@Type(LogMethodInterceptor.class)
public @interface LogMethod {
}
