package org.papaja.adminfly.controller.secure;

import org.papaja.adminfly.core.data.source.ClientDatabase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/server")
public class ServerController {

    @RequestMapping("/dataSource")
    public void dataSource(Model model) {
        model.addAttribute("sources", ClientDatabase.values());
    }

}
