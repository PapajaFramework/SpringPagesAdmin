package org.papaja.adminfly.controller.secure;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server")
public class ServerController {

    @RequestMapping("/status")
    public void status(Model model) {
        Runtime runtime        = Runtime.getRuntime();
        Integer mb             = 1024 * 1024;
        Long    total          = runtime.totalMemory() / mb;
        Long    free           = runtime.freeMemory() / mb;
        Long    maximum        = runtime.maxMemory() / mb;
        Long    used           = total - free;
        Long    maximumPercent = total / (maximum / 100);
        Long    usedPercent    = used / (total / 100);

        model.addAttribute("total", total);
        model.addAttribute("maximum", maximum);
        model.addAttribute("free", free);
        model.addAttribute("used", used);
        model.addAttribute("maximumPercent", maximumPercent);
        model.addAttribute("usedPercent", usedPercent);

        model.addAttribute("os", System.getProperty("os.name"));
        model.addAttribute("java", System.getProperty("java.version"));
    }

    @PreAuthorize("hasRole('SUPERUSER')")
    @RequestMapping("/gc")
    public String gc() {
        Runtime.getRuntime().gc();

        return "redirect:/server/status";
    }

}
