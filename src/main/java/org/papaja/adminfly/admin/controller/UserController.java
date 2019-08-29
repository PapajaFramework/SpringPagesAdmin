package org.papaja.adminfly.admin.controller;

import org.papaja.adminfly.shared.controller.AbstractController;
import org.papaja.adminfly.shared.dto.UserDto;
import org.papaja.adminfly.shared.entity.User;
import org.papaja.adminfly.shared.service.RoleService;
import org.papaja.adminfly.shared.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/users")
@Secured("ROLE_ADMIN")
public class UserController extends AbstractController {

    @Autowired
    private UserService users;

    @Autowired
    private RoleService roles;

    @RequestMapping
    @PreAuthorize("hasAuthority('READ')")
    public String list(
        @RequestParam(value = "page", defaultValue = "1") int page, Model model
    ) {
        model.addAttribute("pagination", users.getUsers(page));

        return "users/list";
    }

    @PreAuthorize("hasAuthority('READ')")
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

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping(value = {"/process/{id:[0-9]+}", "/process"}, method = RequestMethod.POST)
    public ModelAndView process(
        @PathVariable(value = "id", required = false) Integer id,
        @Valid UserDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view   = new ModelAndView("redirect:/users");
        User         entity = users.getUser(id);

        if (!result.hasErrors()) {
            users.save(dto, entity);
            attributes.addFlashAttribute("message", messages.getSuccessMessage("user.saved", entity.getUsername()));
        } else {
            view.addObject("result", result);
            view.addObject("user", Optional.ofNullable(entity).orElseGet(User::new));
            view.addObject("roles", roles.getRoles());
            view.setViewName("users/form");
        }

        return view;
    }

}
