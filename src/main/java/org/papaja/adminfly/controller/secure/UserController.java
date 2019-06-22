package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.UserEntity;
import org.papaja.adminfly.service.security.RoleService;
import org.papaja.adminfly.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        UserEntity user = null;

        if (nonNull(id)) {
            user = users.getProfile(id);
        }

        model.setViewName("users/form");

        model.addObject("user", Optional.ofNullable(user).orElseGet(UserEntity::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String process(
        UserDto user,
        BindingResult result,
        final RedirectAttributes attributes
    ) {
        System.out.println(user);

//        users.store(user);
//
//        System.out.println(user.getId());

        attributes.addFlashAttribute("message", String.format("UserDto '%s' successfully saved", user.getUsername()));

        return "redirect:/users/list";
    }

}
