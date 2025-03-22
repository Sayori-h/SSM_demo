package com.powernode.entity;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom.api")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiConfig {
    private String endpoint;
    private int timeout;
    private boolean enabled;
    private int maxRetries;
}
