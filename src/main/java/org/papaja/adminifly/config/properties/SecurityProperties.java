package org.papaja.adminify.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@SuppressWarnings({"unused"})
@Component
public class SecurityProperties {

    @Value("${app.security.session.cookieName}")
    private String sessionCookieName;

    @Value("${app.security.session.rememberMeCookieName}")
    private String sessionRememberMeCookieName;

    @Value("${app.security.session.rememberMeSecretKey}")
    private String sessionRememberMeSecretKey;

    public String getSessionCookieName() {
        return sessionCookieName;
    }

    public String getSessionRememberMeCookieName() {
        return sessionRememberMeCookieName;
    }

    public String getSessionRememberMeSecretKey() {
        return sessionRememberMeSecretKey;
    }
}
