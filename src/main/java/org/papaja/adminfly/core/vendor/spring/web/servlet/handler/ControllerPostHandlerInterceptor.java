package org.papaja.adminfly.core.vendor.spring.web.servlet.handler;

import org.papaja.adminfly.data.AvailableLocales;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.PropertyResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.web.util.WebUtils.getCookie;

@SuppressWarnings({"unused"})
public class ControllerPostHandlerInterceptor implements HandlerInterceptor {

    private PropertyResolver properties;

    public PropertyResolver getProperties() {
        return properties;
    }

    public void setProperties(PropertyResolver properties) {
        this.properties = properties;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) {
        view.addObject("principal", request.getUserPrincipal());
        view.addObject("locale", LocaleContextHolder.getLocale().toString());
        view.addObject("languages", new AvailableLocales());
        view.addObject("theme", resolveThemeName(request, response));
    }

    private String resolveThemeName(HttpServletRequest request, HttpServletResponse response) {
        String defaultTheme = getProperty("app.view.theme.default");
        String queryName    = getProperty("app.view.theme.queryParameterName");
        String cookieName   = getProperty("app.view.theme.cookieName");
        String theme        = Optional.ofNullable(getCookie(request, cookieName)).map(Cookie::getValue).orElse(defaultTheme);

        if (request.getParameterMap().containsKey(queryName)) {
            theme = request.getParameter(queryName);
            response.addCookie(new Cookie(cookieName, theme));
        }

        return theme;
    }

    private String getProperty(String key) {
        return getProperties().getProperty(key);
    }

}
