package org.papaja.adminfly.module.mdbv.controller;

import org.apache.commons.beanutils.PropertyUtils;
import org.papaja.adminfly.module.mdbv.mongodb.service.RecordService;
import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mongodb.document.Record;
import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePath;
import org.papaja.adminfly.module.mdbv.mysql.service.ValuePathsService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Controller("wsaIndex")
@RequestMapping("/mdbv")
public class IndexController extends AbstractController {

    @Autowired
    private RecordService records;

    @Autowired
    private ValuePathsService paths;

    @RequestMapping
    public RedirectView home() {
        return newRedirect("index");
    }

    @RequestMapping("/routing")
    public ModelAndView routing() {
        ModelAndView mav = newView("routing/index");

        mav.addObject("items", paths.getPaths());
        mav.addObject("types", ValuePath.Type.values());

        return mav;
    }

    @RequestMapping(value = "/routing/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Integer id) {
        ModelAndView mav = newView("routing/index");

        mav.addObject("path", paths.getPath(id));
        mav.addObject("items", paths.getPaths());
        mav.addObject("types", ValuePath.Type.values());

        return mav;
    }

    @RequestMapping(value = {
        "/routing/edit/{id}", "/routing/edit"
    }, method = RequestMethod.POST)
    public RedirectView save(
        @PathVariable(required = false) Integer id, @Valid ValuePathDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        RedirectView redirect = newRedirect("routing");

        if (result.hasErrors()) {
            attributes.addFlashAttribute("result", result);
            attributes.addFlashAttribute("path", dto);
        } else {
            paths.save(dto, paths.getPathOrNew(id));
        }

        return redirect;
    }

    @RequestMapping("/records")
    public void records() {
        for (Record record : records.getRecords(0)) {
            System.out.println(record);
        }
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = newView("index/index");

        mav.addObject("class", getClass().getName());

        return mav;
    }

}
