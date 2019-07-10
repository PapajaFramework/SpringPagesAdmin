package org.papaja.adminfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;

@Controller
@SuppressWarnings("all")
abstract public class AbstractController {

    @Autowired
    private MessageSource messages;

    protected String getMessage(String key, Object... parameters) {
        return messages.getMessage(key, parameters, LocaleContextHolder.getLocale());
    }

}
