package org.papaja.adminify.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public void home(Authentication authentication, Model model) {
        model.addAttribute("authentication", authentication);
    }

}
