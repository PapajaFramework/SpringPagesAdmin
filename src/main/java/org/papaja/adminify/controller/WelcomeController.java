package org.papaja.adminify.controller;

import org.papaja.adminify.entity.security.AuthUser;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/hello";
    }

    @Secured("ROLE_VIEWER")
    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(Authentication authentication) {
        AuthUser user = (AuthUser) authentication.getPrincipal();

        System.out.println(user.getUser().getRoles());

        return user.getUsername();
    }

}
