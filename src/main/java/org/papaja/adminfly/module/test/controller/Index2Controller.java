package org.papaja.adminfly.module.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Index2Controller {

    @ResponseBody
    @GetMapping("/module/blog/index2")
    public String index() {
        return getClass().getName();
    }

}
