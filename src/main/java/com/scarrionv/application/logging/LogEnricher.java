package com.scarrionv.application.logging;

import io.micronaut.core.util.StringUtils;
import jakarta.inject.Singleton;
import org.slf4j.MDC;

@Singleton
public class LogEnricher {
    private static final String TENANT_ID_LOGGER_ID = "tenantId";

    private String tenantId;

    public LogEnricher setTenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    public void enrich() {
        if (StringUtils.isNotEmpty(tenantId)) {
            MDC.put(TENANT_ID_LOGGER_ID, tenantId);
        }
    }
}
