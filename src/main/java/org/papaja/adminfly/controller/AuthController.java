package org.papaja.adminfly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private MessageSource messages;

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login")
    public String login() {
        return "login/login";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/logout")
    public void logout() { }

}
