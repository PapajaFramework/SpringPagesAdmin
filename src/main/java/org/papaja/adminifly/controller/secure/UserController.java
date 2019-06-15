package org.papaja.adminify.controller.secure;

import org.papaja.adminify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService users;

    @RequestMapping("list")
    public void list(
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model
    ) {
        model.addAttribute("users", users.getUsers());
    }

}
