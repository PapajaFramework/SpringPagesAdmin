package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.entity.security.User;
import org.papaja.adminfly.service.RoleService;
import org.papaja.adminfly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

import static java.util.Objects.*;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService users;

    @Autowired
    private RoleService roles;

    @InitBinder
    private void initialize(WebDataBinder binder) {
        //        binder.addValidators();
    }

    @RequestMapping("/list")
    public void list(
        @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("users", users.getUsers(page));
    }

    @RequestMapping({"/edit/{id}", "/create"})
    public ModelAndView form(
        @PathVariable(value = "id", required = false) Integer id,
        ModelAndView model
    ) {
        User user = null;

        if (nonNull(id)) {
            user = users.getProfile(id);
        }

        model.setViewName("users/form");

        model.addObject("user", Optional.ofNullable(user).orElseGet(User::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String process(
        @ModelAttribute @Valid User user,
        BindingResult result,
        final RedirectAttributes attributes
    ) {
        users.persist(user);

        attributes.addFlashAttribute("message", String.format("User '%s' successfully saved", user.getUsername()));

        return "redirect:/users/list";
    }

}
