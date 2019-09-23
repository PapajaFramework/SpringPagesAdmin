package org.papaja.adminfly.module.kv.controller;

import org.papaja.adminfly.module.kv.dto.KeyValueDto;
import org.papaja.adminfly.module.kv.service.KVService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/kv", produces = MediaType.TEXT_PLAIN_VALUE)
public class IndexController extends AbstractController {

    @Autowired
    private KVService kvs;

    @GetMapping(value = {"/", "/index", "/edit/{id:[0-9]+}"})
    public ModelAndView index(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView mav = newView("index");

        mav.addObject("entity", kvs.getOne(id));
        mav.addObject("kvs", kvs.getAll());

        return mav;
    }

    @PostMapping(value = {"/save", "/save/{id:[0-9]+}"})
    public ModelAndView save(
        @Valid KeyValueDto dto, BindingResult result, RedirectAttributes attributes,
        @PathVariable(value = "id", required = false) Integer id
    ) {
        ModelAndView mav = newView("index");

        mav.addObject("kvs", kvs.getAll());

        if (result.hasErrors()) {
            mav.addObject("result", result);
            mav.addObject("entity", dto);
        } else {
            attributes.addFlashAttribute("message",
                messages.getSuccessMessage("record.saved", dto.getKey()));
            kvs.save(dto, kvs.getOne(id));
            mav = newRedirect("index");
        }

        return mav;
    }

}
