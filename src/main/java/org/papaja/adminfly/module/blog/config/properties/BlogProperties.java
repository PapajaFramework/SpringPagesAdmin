package org.papaja.adminfly.module.blog.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {

    @Value("${app.blog.sessionName}")
    private String sessionName;

    public String getSessionName() {
        return sessionName;
    }
}
