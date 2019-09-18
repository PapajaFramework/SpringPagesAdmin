package org.papaja.adminfly.admin.controller;

import org.papaja.adminfly.shared.controller.AbstractController;
import org.papaja.commons.structure.tuple.Quartet;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@SuppressWarnings({"unused"})
public class WelcomeController extends AbstractController {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public void home(Authentication authentication, Model model) {

        Quartet quartet = new Quartet(1, 2, 3, 4);

        System.out.println(quartet.size());

        model.addAttribute("authentication", authentication);
    }

}
