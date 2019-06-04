package org.papaja.adminify.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({Exception.class})
    public String handleException(Exception exception, Model model) {
        String template = "errors/exception";

        model.addAttribute("exception", exception);

        return template;
    }

}
