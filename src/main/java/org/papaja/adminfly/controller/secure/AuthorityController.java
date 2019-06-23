package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.entity.security.PrivilegeEntity;
import org.papaja.adminfly.entity.security.RoleEntity;
import org.papaja.adminfly.service.security.PrivilegeService;
import org.papaja.adminfly.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/authority")
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

    @RequestMapping(value = {"/process/privilege/{id:[0-9]+}", "/process/privilege"}, method = RequestMethod.POST)
    public String privileges(
        @PathVariable(value = "id", required = false) Integer id,
        PrivilegeEntity entity,
        RedirectAttributes attributes
    ) {
        entity.setName(entity.getName().toUpperCase());

        privileges.store(entity);

        attributes.addFlashAttribute("message", String.format("Privilege '%s' was successfully saved", entity.getName()));

        return "redirect:/authority";
    }

    @RequestMapping(value = {"/process/role/{id:[0-9]+}", "/process/role"}, method = RequestMethod.POST)
    public String roles(
        @PathVariable(value = "id", required = false) Integer id,
        RoleEntity entity,
        RedirectAttributes attributes
    ) {
        entity.setName(entity.getName().toUpperCase());

        roles.store(entity);

        attributes.addFlashAttribute("message", String.format("Role '%s' was successfully saved", entity.getName()));

        return "redirect:/authority";
    }

}
