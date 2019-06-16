package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.entity.security.User;
import org.papaja.adminfly.service.RoleService;
import org.papaja.adminfly.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService users;

    @Autowired
    private RoleService roles;

    @RequestMapping("/list")
    public void list(
        @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("users", users.getUsers(page));
    }

    @RequestMapping({"/edit/{id}", "/create"})
    public ModelAndView form(@PathVariable(value = "id", required = false) Integer id, ModelAndView model) {
        User user = users.getProfile(id);

        model.setViewName("user/form");
        model.addObject("user", user);
        model.addObject("roles", roles.getRoles());

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
        System.out.println(user.getPassword());

        return user.toString();
    }

}
