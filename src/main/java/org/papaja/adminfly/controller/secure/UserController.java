package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.User;
import org.papaja.adminfly.service.security.RoleService;
import org.papaja.adminfly.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/users")
@Secured("ROLE_ADMIN")
public class UserController {

    @Autowired
    private UserService users;

    @Autowired
    private RoleService roles;

    @InitBinder
    private void initialize(WebDataBinder binder) {
        //        binder.addValidators();
    }

    @RequestMapping
    public String list(
        @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("pagination", users.getUsers(page));

        return "users/list";
    }

    @RequestMapping({"/edit/{id:[0-9]+}", "/create"})
    public ModelAndView form(
        @PathVariable(value = "id", required = false) Integer id, ModelAndView model
    ) {
        User user = users.getUser(id);

        model.setViewName("users/form");

        model.addObject("user", Optional.ofNullable(user).orElseGet(User::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SECURITY')")
    public String process(@PathVariable("id") Integer id, UserDto dto) {
        User entity = users.getUser(id);

        users.store(dto, entity);

        return "redirect:/users";
    }

}
