package com.medisanaspace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class RequestSecurity {

    public static final String USER_AGENT = "user-agent";
    public static final String GARMIN_HEALTH_API = "Garmin Health API";

    public boolean check(HttpServletRequest request) {
        log.info("Performing security check for request {} {}", request.getMethod(), request.getRequestURI());
        logHeaders(request);
        String userAgent = request.getHeader(USER_AGENT);
        return GARMIN_HEALTH_API.equals(userAgent);
    }

    private static void logHeaders(HttpServletRequest request) {
        request
                .getHeaderNames()
                .asIterator()
                .forEachRemaining(headerName -> log.info(String.format("'%s': %s", headerName, request.getHeader(headerName))));
    }
}
