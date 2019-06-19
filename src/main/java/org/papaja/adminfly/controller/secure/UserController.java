package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.core.request.UserRequest;
import org.papaja.adminfly.entity.security.User;
import org.papaja.adminfly.service.RoleService;
import org.papaja.adminfly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;
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

    @RequestMapping("/list")
    public void list(
        @RequestParam(value = "page", defaultValue = "1") int page,
        Model model
    ) {
        model.addAttribute("users", users.getUsers(page));
    }

    @RequestMapping({"/edit/{id}", "/create"})
    public ModelAndView form(
            @PathVariable(value = "id", required = false) Integer id,
            ModelAndView model
    ) {
        User user = null;

        if (Objects.nonNull(id)) {
            user = users.getProfile(id);
        }

        model.setViewName("users/form");
        model.addObject("user", Optional.ofNullable(user).orElseGet(User::new));
        model.addObject("roles", roles.getRoles());

        return model;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public String process(
        UserRequest request,
        @ModelAttribute("user") @Valid User user,
        BindingResult result,
        Model model,
        final RedirectAttributes attributes
    ) {
//        System.out.println(user);
//        System.out.println(user.getPassword());

        System.out.println();
        System.out.println(user);
        System.out.println();
        System.out.println(request);
        System.out.println();

        return user.toString();
    }

}
