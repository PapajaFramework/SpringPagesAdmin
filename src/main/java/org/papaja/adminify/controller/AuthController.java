package org.papaja.adminify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @RequestMapping(value = "/login", produces = "text/html; charset=UTF-8")
    public void login() {

    }

    @RequestMapping("/logout")
    public void logout() {

    }

}
