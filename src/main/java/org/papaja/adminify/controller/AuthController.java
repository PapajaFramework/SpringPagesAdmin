package org.papaja.adminify.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public void login() {

    }

    @RequestMapping("/logout")
    public void logout() {

    }

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(Authentication authentication) {
        return authentication.getName();
    }

}
