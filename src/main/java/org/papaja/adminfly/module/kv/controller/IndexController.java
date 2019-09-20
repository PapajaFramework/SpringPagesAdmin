package org.papaja.adminfly.module.kv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping(value = "kv", produces = "plain/text")
public class IndexController {

    @Autowired
    private Environment environment;

    @GetMapping
    public String welcome() {
        return format("Welcome to '%s'", environment.getProperty("module.kv.name"));
    }

}
