package org.papaja.adminify.controller;

import org.papaja.adminify.entity.security.AuthUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SuppressWarnings({"unused"})
@PreAuthorize("hasAuthority('REMOVE')")
public class WelcomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/hello";
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @ResponseBody
    @RequestMapping(value = "/hello")
    public String hello(Authentication authentication) {
        AuthUser user = (AuthUser) authentication.getPrincipal();

        System.out.println(user.getUser().getRoles());

        return user.getUsername();
    }

}
