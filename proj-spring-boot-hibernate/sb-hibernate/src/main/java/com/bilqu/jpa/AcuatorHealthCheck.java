package com.bilqu.jpa;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class AcuatorHealthCheck implements HealthIndicator {

    @Override
    public Health health() {
        return null;
    }
}
