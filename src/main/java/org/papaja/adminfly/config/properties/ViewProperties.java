package org.papaja.adminfly.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ViewProperties {

    @Value("${app.view.theme.cookieName}")
    private String themeCookieName;

    public String getThemeCookieName() {
        return themeCookieName;
    }
}
