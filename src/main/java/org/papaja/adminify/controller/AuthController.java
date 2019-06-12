package org.papaja.adminify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    @Autowired
    public void login() {

    }

    @RequestMapping("/logout")
    public void logout() {

    }

}
