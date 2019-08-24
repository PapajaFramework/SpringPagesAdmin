package org.papaja.adminfly.module.mdbv.controller;

import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order
public class GlobalModuleController {

    @Autowired
    private SourceService service;

    @ModelAttribute
    public void handleRequest(HttpServletRequest request, Model view) {
        view.addAttribute("sourceService", service);
    }

}
