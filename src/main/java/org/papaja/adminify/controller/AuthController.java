package org.papaja.adminify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @RequestMapping("/login")
    public void login() {

    }

    @RequestMapping("/logout")
    public void logout() {

    }

}
