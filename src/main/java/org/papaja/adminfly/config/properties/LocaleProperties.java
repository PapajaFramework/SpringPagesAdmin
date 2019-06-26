package org.papaja.adminfly.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@SuppressWarnings({"unused"})
@Component
public class LocaleProperties {

    @Value("${app.locale.cookieName}")
    private String cookieName;

    @Value("${app.locale.defaultLocale}")
    private String defaultLocale;

    @Value("${app.locale.queryParameterName}")
    private String queryParameterName;

    public String getCookieName() {
        return cookieName;
    }

    public String getDefaultLocale() {
        return defaultLocale;
    }

    public String getQueryParameterName() {
        return queryParameterName;
    }
}
