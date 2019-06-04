package org.papaja.adminify.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @RequestMapping("/login")
    public void login(RedirectAttributes attributes) {
        System.out.println(attributes);
    }

    @RequestMapping("/logout")
    public void logout() {

    }

}
