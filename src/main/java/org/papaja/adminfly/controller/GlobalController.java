package org.papaja.adminfly.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Locale;
import java.util.Objects;

@SuppressWarnings({"unused"})
@ControllerAdvice
public class GlobalController {

    @ExceptionHandler({Exception.class})
    public String handleException(
            Exception exception, Model model,
            HttpServletRequest request, HttpServletResponse response
    ) {
        String template = "errors/exception";

        model.addAttribute("stack", ExceptionUtils.getStackTrace(exception));
        model.addAttribute("exceptionClass", exception.getClass().getName());
        model.addAttribute("rootMassage", exception.getMessage());

        return template;
    }

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model, Principal principal) {
        if (Objects.nonNull(principal)) {
            model.addAttribute("principal", principal);
        }

        Locale locale = LocaleContextHolder.getLocale();

        model.addAttribute("locale", locale);
        model.addAttribute("localeName", locale.getDisplayName());
    }

}
