package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.dto.security.UserDto;
import org.papaja.adminfly.entity.security.UserEntity;
import org.papaja.adminfly.service.security.RoleService;
import org.papaja.adminfly.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
        UserEntity user = users.getUser(id);

        model.setViewName("users/form");

        model.addObject("user", Optional.ofNullable(user).orElseGet(UserEntity::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @RequestMapping(value = "/{id:[0-9]+}", method = RequestMethod.POST)
    public String process(@PathVariable("id") Integer id, UserDto dto) {
        UserEntity entity = users.getUser(id);
        System.out.println(entity);
        System.out.println(id);
        users.store(dto, entity);

        return "redirect:/users";
    }

}
