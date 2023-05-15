package com.scarrionv.application.annotations;

import com.scarrionv.application.interceptors.method.LogMethodInterceptor;
import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import io.micronaut.tracing.annotation.NewSpan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Around()
@Type(LogMethodInterceptor.class)
@NewSpan
public @interface LogAndTrace {
    boolean metrics() default false;
}
