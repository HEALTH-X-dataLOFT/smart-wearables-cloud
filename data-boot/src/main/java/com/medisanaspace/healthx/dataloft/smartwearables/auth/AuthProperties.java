package com.medisanaspace.healthx.dataloft.smartwearables.auth;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "auth")
@Data
public class AuthProperties {

    @NotNull
    private JWEProperties jwe;
    private List<String> issuers;

    @Data
    public static class JWEProperties {
        private boolean rejectJWT;
        private String privateKeyFile;
    }
}
