package org.papaja.adminify.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({Throwable.class})
    public String handleException(Throwable exception, Model model) {
        String template = "errors/exception";

        model.addAttribute("message", exception.getMessage());
        model.addAttribute("className", exception.getClass().getName());

        return template;
    }

}
