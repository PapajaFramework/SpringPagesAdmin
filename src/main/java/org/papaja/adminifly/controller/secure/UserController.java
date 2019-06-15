package org.papaja.adminifly.controller.secure;

import org.papaja.adminifly.entity.security.User;
import org.papaja.adminifly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService users;

    @RequestMapping("/list")
    public void list(
            @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("users", users.getUsers(page));
    }

    @RequestMapping({"/edit/{id}", "/create"})
    public ModelAndView form(@PathVariable(value = "id", required = false) int id, ModelAndView model) {
        User user = id > 0 ? users.getProfile(id) : new User();

        System.out.println(user);

        model.setViewName("user/form");
        model.addObject("user", user);

        return model;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String process(
            @ModelAttribute("user") @Validated User user,
            BindingResult result,
            Model model,
            final RedirectAttributes attributes
    ) {
        System.out.println(user);

        return user.toString();
    }

}
