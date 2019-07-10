package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.data.SystemInformation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @RequestMapping
    public String redirect() {
        return "redirect:/application/status";
    }

    @RequestMapping("/status")
    public void status(Model model) {
        model.addAttribute("info", new SystemInformation());
    }

    @RequestMapping("/gc")
    @PreAuthorize("hasAuthority('SYSTEM')")
    public String gc() {
        Runtime.getRuntime().gc();

        return "redirect:/application/status";
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting")
    public void setting(HttpServletRequest request, Model model) {
        model.addAttribute("uri", request.getRequestURI());
    }

}
