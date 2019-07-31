package org.papaja.adminfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Controller
@SuppressWarnings({"unused"})
abstract public class AbstractController {

    @Autowired
    private MessageSource messages;

    protected String getPrefix() {
        RequestMapping annotation = this.getClass().getAnnotation(RequestMapping.class);
        List<String>   mapping    = Arrays.asList(annotation.value());

        return mapping.size() > 0 ? mapping.get(0) : null;
    }

    protected String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters, LocaleContextHolder.getLocale());
    }

    protected ModelAndView newView(String view) {
        return new ModelAndView(normalizeViewPath(view));
    }

    protected RedirectView newRedirect(String view) {
        return new RedirectView(normalizeViewPath(view));
    }

    protected String normalizeViewPath(String view) {
        view = view.startsWith("/") ? view.substring(1) : view;

        return format("%s/%s", getPrefix(), view);
    }

}
