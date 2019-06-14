package org.papaja.adminify.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController {

    @Value("${app.name}")
    private String name;

    @RequestMapping("/")
    public String home() {
        return "redirect:/hello";
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @RequestMapping(value = "/name")
    @ResponseBody
    public String getClassName() {
        return getClass().getName();
    }

    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(Authentication authentication) {
        return authentication.getName() + " " + name + " " + "Привет!";
    }

    @RequestMapping(value = "/test")
    public void test(Authentication authentication, Model model) {
        model.addAttribute("authentication", authentication);
    }

}
