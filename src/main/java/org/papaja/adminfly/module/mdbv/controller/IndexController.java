package org.papaja.adminfly.module.mdbv.controller;

import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller("wsaIndex")
@RequestMapping("/mdbv")
public class IndexController extends AbstractController {

    @RequestMapping
    public RedirectView home() {
        return newRedirect("index");
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = newView("index/index");

        mav.addObject("class", getClass().getName());

        return mav;
    }

}
