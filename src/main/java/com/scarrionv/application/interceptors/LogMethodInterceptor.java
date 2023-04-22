package com.scarrionv.application.interceptors;

import com.scarrionv.application.annotations.LogMethod;
import io.micrometer.core.instrument.MeterRegistry;
import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.type.Argument;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.StringJoiner;

@Slf4j
@Singleton
public class LogMethodInterceptor implements MethodInterceptor<Object, Object> {
    private static final String METRICS_PARAM_NAME = "metrics";
    private final MeterRegistry meterRegistry;

    public LogMethodInterceptor(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public Object intercept(MethodInvocationContext<Object, Object> context) {
        String methodName = context.getMethodName();
        logMethod(methodName, context);
        addMetricsIfNecessary(methodName, context);
        return context.proceed();
    }

    private void logMethod(String methodName, MethodInvocationContext<Object, Object> context) {
        log.info("Calling method [{}] with arguments [{}].", methodName, getArguments(context));
    }

    private void addMetricsIfNecessary(String methodName, MethodInvocationContext<Object, Object> context) {
        context.findAnnotation(LogMethod.class)
                .flatMap(logMethodAnnotationValue -> logMethodAnnotationValue.get(METRICS_PARAM_NAME, Argument.BOOLEAN))
                .ifPresent(isMetric -> {
                    if(Boolean.TRUE.equals(isMetric)){
                        addMetrics(methodName);
                    }
                });
    }

    private void addMetrics(String methodName) {
        String metricName = "controller";
        String metricTag = "method";
        log.trace("Updating metrics: metric [{}], tag [{}], value [{}]", metricName, metricTag, methodName);
        meterRegistry.counter(metricName, metricTag, methodName).increment();
    }

    private static StringJoiner getArguments(MethodInvocationContext<Object, Object> context) {
        StringJoiner joiner = new StringJoiner("; ");
        context.getParameterValueMap().forEach((param, value) -> joiner.add("Parameter: " + param + ", value: " + value));
        return joiner;
    }
}
