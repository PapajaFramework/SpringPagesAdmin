package org.papaja.adminify.controller.secure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure/users")
@SuppressWarnings("unused")
public class UserController {

    @RequestMapping("list")
    public void list() {

    }

}
