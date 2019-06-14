package org.papaja.adminify.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecurityProperties {

    @Value("${app.session.sessionCookie}")
    private String sessionCookie;

    @Value("${app.session.rememberMeName}")
    private String rememberMeName;

    @Value("${app.session.rememberMeSecret}")
    private String rememberMeSecret;

    public String getSessionCookie() {
        return sessionCookie;
    }

    public String getRememberMeName() {
        return rememberMeName;
    }

    public String getRememberMeSecret() {
        return rememberMeSecret;
    }
}
