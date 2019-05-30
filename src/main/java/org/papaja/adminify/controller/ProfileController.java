package org.papaja.adminify.controller;

import org.papaja.adminify.entity.Profile;
import org.papaja.adminify.service.GalleryService;
import org.papaja.adminify.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SuppressWarnings({"unused"})
@Controller
public class ProfileController {

    @Autowired
    private ProfileService profiles;

    @Autowired
    private GalleryService galleries;

    @RequestMapping("/")
    public String list(Model model) {
        String template = "profiles";

        model.addAttribute("galleries", galleries.getGalleries());
        model.addAttribute("class", getClass().getName());

        return template;
    }

    @RequestMapping("/profile/{id}")
    public String update(Model model, @PathVariable("id") Integer id) {
        String template = "profile";
        Profile profile = profiles.getProfile(id);

        model.addAttribute("profile", profile);

        profile.setUpdated(Timestamp.valueOf(LocalDateTime.now()));
        profiles.persist(profile);

        return template;
    }

}