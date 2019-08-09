package org.papaja.adminfly.commons.vendor.jtwig.extension.theme;

import org.jtwig.functions.JtwigFunction;
import org.jtwig.web.servlet.ServletRequestHolder;
import org.springframework.ui.context.Theme;
import org.springframework.ui.context.ThemeSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ThemeResolver;

import java.util.Collection;
import java.util.Collections;

abstract public class AbstractThemeMessagesFunction implements JtwigFunction {

    @Override
    public Collection<String> aliases() {
        return Collections.emptyList();
    }

    protected Theme getCurrentTheme() {
        return getBean(ThemeSource.class).getTheme(getBean(ThemeResolver.class).resolveThemeName(ServletRequestHolder.get()));
    }

    protected <T> T getBean(Class<T> reflection) {
        return WebApplicationContextUtils.getWebApplicationContext(ServletRequestHolder.get().getServletContext())
                .getBean(reflection);
    }

}
