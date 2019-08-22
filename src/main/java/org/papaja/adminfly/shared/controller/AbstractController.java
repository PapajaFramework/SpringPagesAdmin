package org.papaja.adminfly.shared.controller;

import org.papaja.adminfly.shared.service.FlashMessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    protected FlashMessageService messages;

    protected String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters);
    }

    protected ModelAndView newView(String view) {
        return new ModelAndView(normalizeViewPath(view));
    }

    private String normalizeViewPath(String view) {
        return format("%s/%s", getPrefix(), (view.startsWith("/") ? view.substring(1) : view));
    }

    protected String getPrefix() {
        RequestMapping annotation = this.getClass().getAnnotation(RequestMapping.class);
        List<String>   mapping    = Arrays.asList(annotation.value());

        return mapping.size() > 0 ? mapping.get(0) : null;
    }

    protected ModelAndView newRedirect(String view) {
        return new ModelAndView(format("redirect:%s", normalizeViewPath(view)));
    }

    protected RedirectView newRedirectView(String view) {
        return new RedirectView(normalizeViewPath(view));
    }

}
