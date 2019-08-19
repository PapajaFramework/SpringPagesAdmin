package org.papaja.adminfly.module.wsa.controller;

import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller("wsaIndex")
@RequestMapping("/wsa")
public class IndexController extends AbstractController {

    @ResponseBody
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = newView("index/index");

        mav.addObject("class", getClass().getName());

        return mav;
    }

}
