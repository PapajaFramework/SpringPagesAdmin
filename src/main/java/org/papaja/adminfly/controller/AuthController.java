package org.papaja.adminfly.controller;

import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("isAnonymous()")
    @RequestMapping(value = "/login")
    public String login() {
        return "login/login";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/logout")

    public void logout() { }

}
