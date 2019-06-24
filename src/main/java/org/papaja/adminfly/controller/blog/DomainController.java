package org.papaja.adminfly.controller.blog;

import org.papaja.adminfly.service.blog.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/domains")
@Secured("ROLE_ADMIN")
public class DomainController {

    @Autowired
    private DomainService domains;

    @RequestMapping
    public String domains(Model model) {
        model.addAttribute("domains", domains.getDomains());

        return "domains/list";
    }

}
