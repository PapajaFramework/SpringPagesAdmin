package org.papaja.adminfly.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Locale;
import java.util.Objects;

@SuppressWarnings({"unused"})
@ControllerAdvice
public class GlobalController {

    @Autowired
    private HttpSession session;

    @ExceptionHandler({AccessDeniedException.class})
    public String handleAccessDeniedException(Model model, HttpServletRequest request, Principal principal) {
        model.addAttribute("uri", request.getRequestURI());

        handleRequest(request, model, principal);

        return "errors/accessDenied";
    }

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model model, Principal principal) {
        if (Objects.nonNull(principal)) {
            model.addAttribute("principal", principal);
        }

        Locale locale = LocaleContextHolder.getLocale();

        model.addAttribute("_locale", locale.toString());

        if (request.getParameterMap().containsKey("_theme")) {
            session.setAttribute("_theme", request.getParameter("_theme"));
        }

        model.addAttribute("_theme", session.getAttribute("_theme"));
    }

    @ExceptionHandler({Exception.class})
    public String handleException(
        Exception exception, Model model, HttpServletRequest request, HttpServletResponse response, Principal principal
    ) {
        String template = "errors/exception";

        model.addAttribute("stack", ExceptionUtils.getStackTrace(exception));
        model.addAttribute("exceptionClass", exception.getClass().getName());
        model.addAttribute("rootMassage", exception.getMessage());

        handleRequest(request, model, principal);

        return template;
    }

}
