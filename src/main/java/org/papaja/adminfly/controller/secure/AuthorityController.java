package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.dto.security.PrivilegeDto;
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
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Controller
@RequestMapping("/authority")
@Secured("ROLE_ADMIN")
public class AuthorityController {

    @Autowired
    private PrivilegeService privileges;

    @Autowired
    private RoleService roles;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam("id") @Valid @Min(5) Integer id, Errors result) {
        System.out.println(id);

        System.out.println(result.hasErrors());
        System.out.println(result.getAllErrors());

        return getClass().getName();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("roles", roles.getRoles());
        model.addAttribute("privileges", privileges.getPrivileges());

        return "authority/list";
    }

    @RequestMapping(
            value = "/role/edit/{id:[0-9]+}",
            method = RequestMethod.GET
    )
    public ModelAndView edit(@PathVariable("id") Integer id) {
        ModelAndView model = new ModelAndView("authority/role/form");

        model.addObject("role", roles.getRole(id));
        model.addObject("privileges", privileges.getPrivileges());

        return model;
    }

    @RequestMapping(
            value = "/{entity:[a-z]+}/remove/{id:[0-9]+}",
            method = RequestMethod.GET
    )
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

        attributes.addFlashAttribute("message", String.format("Record '%s' with ID: %d was successfully removed",
                name, id));

        return "redirect:/authority";
    }

    @RequestMapping(value = {"/process/privilege/{id:[0-9]+}", "/process/privilege"},
            method = RequestMethod.POST)
    public String privileges(@Valid PrivilegeDto dto, final BindingResult result) {
//        privilege.setName(privilege.getName().toUpperCase());
//        privileges.store(privilege);

        System.out.println(dto);
        System.out.println(result.hasErrors());
        System.out.println(result.getAllErrors());

//        attributes.addFlashAttribute("message", String.format("Privilege '%s' was successfully saved", privilege.getName()));

        return "redirect:/authority";
    }

    @RequestMapping(value = {"/process/role/{id:[0-9]+}", "/process/role"},
            method = RequestMethod.POST)
    //@PreAuthorize("hasAuthority('SECURITY')")
    public String roles(
            @PathVariable(value = "id", required = false) Integer id,
            @ModelAttribute @Validated Role dto,
            RedirectAttributes attributes,
            BindingResult result
    ) {
        Role role = roles.getRole(id);

        System.out.println(result.hasErrors());
        System.out.println(result.getAllErrors());

//        roles.store(dto, role);
        attributes.addFlashAttribute("message", String.format("Role '%s' was successfully saved", dto.getName()));

        return "redirect:/authority";
    }

}
