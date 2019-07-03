package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.dto.security.RoleDto;
import org.papaja.adminfly.entity.security.Privilege;
import org.papaja.adminfly.entity.security.Role;
import org.papaja.adminfly.service.security.PrivilegeService;
import org.papaja.adminfly.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/authority")
@Secured("ROLE_ADMIN")
public class AuthorityController {

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleService roles;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("roles", roles.getRoles());
        model.addAttribute("privileges", privileges.getPrivileges());

        return "authority/list";
    }

    @RequestMapping(value = "/role/edit/{id:[0-9]+}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("authority/role/form");

        model.addObject("role", roles.getRole(id));
        model.addObject("privileges", privileges.getPrivileges());

        return model;
    }

    @RequestMapping(value = "/{entity:[a-z]+}/remove/{id:[0-9]+}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('SECURITY')")
    public String remove(
        @PathVariable("entity") String name, @PathVariable("id") Integer id, RedirectAttributes attributes
    ) {
        switch (name) {
            case "role":
                roles.remove(id);
                break;
            case "privilege":
                privileges.remove(id);
                break;
        }

        attributes.addFlashAttribute("message", String.format("Record '%s' with ID: %d was successfully removed", name, id));

        return "redirect:/authority";
    }

    @RequestMapping(value = {"/process/privilege/{id:[0-9]+}", "/process/privilege"}, method = RequestMethod.POST)
    public String privileges(@Valid Privilege dto, final BindingResult result, RedirectAttributes attributes) {
        //        privilege.setName(privilege.getName().toUpperCase());
        //        privileges.merge(privilege);

        attributes.addFlashAttribute("result", result);

        return "redirect:/authority";
    }

    @RequestMapping(value = {"/process/role/{id:[0-9]+}", "/process/role"}, method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('SECURITY')")
    public ModelAndView roles(
        @PathVariable(value = "id", required = false) Integer id,
        @Valid RoleDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view = new ModelAndView("redirect:/authority");

        if (!result.hasErrors()) {
            Role role = roles.getRole(id);
            roles.store(dto, role);
            attributes.addFlashAttribute("message", String.format("Role '%s' was successfully saved", dto.getName()));
        } else {
            view.setViewName("authority/role/form");
            view.addObject("role", roles.getRole(id));
            view.addObject("privileges", privileges.getPrivileges());
            view.addObject("result", result);
        }

        return view;
    }

}
