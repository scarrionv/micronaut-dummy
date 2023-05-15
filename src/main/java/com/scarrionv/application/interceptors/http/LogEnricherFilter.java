package com.scarrionv.application.interceptors.http;


import com.scarrionv.application.logging.LogEnricher;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

@Filter("/**")
public class LogEnricherFilter implements HttpServerFilter {

    private static final String TENANT_ID_HTTP_HEADER = "TenantId";

    private final LogEnricher logEnricher;

    public LogEnricherFilter(LogEnricher logEnricher) {
        this.logEnricher = logEnricher;
    }

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        request.getHeaders();
        logEnricher
                .setTenantId(request.getHeaders().get(TENANT_ID_HTTP_HEADER))
                .enrich();
        return chain.proceed(request);
    }
}
