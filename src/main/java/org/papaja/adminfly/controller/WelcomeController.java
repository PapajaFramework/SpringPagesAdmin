package org.papaja.adminfly.controller;

import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.repository.blog.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController {

    @Autowired
    private PostRepository repository;

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public void home(Authentication authentication, Model model) {
        Post post = repository.getPost(1);

        System.out.println(post);

        model.addAttribute("authentication", authentication);
    }

}
