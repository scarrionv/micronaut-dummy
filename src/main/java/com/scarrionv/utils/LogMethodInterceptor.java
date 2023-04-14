package com.scarrionv.utils;

import io.micrometer.core.instrument.MeterRegistry;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

@Slf4j
@Singleton
public class LogMethodInterceptor implements MethodInterceptor<Object, Object> {
    private final MeterRegistry meterRegistry;

    public LogMethodInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        StringJoiner joiner = new StringJoiner("; ");
        context.getParameterValueMap().forEach((param, value) -> joiner.add("Parameter: " + param + ", value: " + value));
        String methodName = context.getMethodName();
        log.info("Calling method [{}] with arguments [{}]", methodName, joiner);
        meterRegistry.counter("controller", "method", methodName).increment();
        return context.proceed();
    }
}
