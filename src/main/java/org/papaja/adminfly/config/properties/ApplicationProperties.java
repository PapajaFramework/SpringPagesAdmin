package org.papaja.adminfly.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {

    @Value("${app.name}")
    private String name;

    public String getName() {
        return name;
    }
}
