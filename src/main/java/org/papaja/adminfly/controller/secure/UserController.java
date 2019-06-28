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
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public ModelAndView process(
        @PathVariable("id") Integer id, @Valid UserDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view = new ModelAndView("redirect:/users");
        User entity = users.getUser(id);

        if (!result.hasErrors()) {
            users.store(dto, entity);
            attributes.addFlashAttribute("message",
                String.format("User '%s' was successfully saved!", entity.getUsername()));
        } else {
            view.addObject("result", result);
            view.addObject("user", Optional.ofNullable(entity).orElseGet(User::new));
            view.addObject("roles", roles.getRoles());
            view.setViewName("users/form");
        }

        return view;
    }

}
