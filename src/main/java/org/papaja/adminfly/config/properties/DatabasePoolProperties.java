package org.papaja.adminfly.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:database-pool.properties")
public class DatabasePoolProperties {

    @Value("${connection}")
    private String connection;

    @Override
    public String toString() {
        return String.format("DatabasePoolProperties{connection=%s}", connection);
    }
}
