package com.scarrionv.utils;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

@Slf4j
@Singleton
public class LogMethodInterceptor implements MethodInterceptor<Object, Object> {

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        StringJoiner joiner = new StringJoiner("; ");
        context.getParameterValueMap().forEach((param, value) -> joiner.add("Parameter: " + param + ", value: " + value));
        log.info("Calling method [{}] with arguments [{}]", context.getMethodName(), joiner);
        return context.proceed();
    }
}
