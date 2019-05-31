package org.papaja.adminify.controller;

import org.papaja.adminify.entity.User;
import org.papaja.adminify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SuppressWarnings({"unused"})
@Controller
@Secured("ADMIN")
public class ProfileController {

    @Autowired
    private UserService profiles;

    @RequestMapping("/")
    public String list(Model model) {
        String template = "home";

        model.addAttribute("class", getClass().getName());

        return template;
    }

    @RequestMapping("/user/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        String template = "user";
        User   user     = profiles.getProfile(id);

        model.addAttribute("user", user);

        user.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
        profiles.persist(user);

        return template;
    }

}