package org.papaja.adminfly.module.mdbv.controller;

import org.apache.commons.beanutils.PropertyUtils;
import org.papaja.adminfly.module.mdbv.mongodb.document.Record;
import org.papaja.adminfly.module.mdbv.mongodb.repository.RecordRepository;
import org.papaja.adminfly.module.mdbv.mysql.entity.ValuePaths;
import org.papaja.adminfly.module.mdbv.mysql.service.ValuePathsService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Controller("wsaIndex")
@RequestMapping("/mdbv")
public class IndexController extends AbstractController {

    @Autowired
    private RecordRepository repository;

    @Autowired
    private ValuePathsService paths;

    @RequestMapping
    public RedirectView home() {
        return newRedirect("index");
    }

    @RequestMapping("/routing")
    public ModelAndView routing() {
        ModelAndView mav = newView("routing/index");

        mav.addObject("paths", paths.getPaths());

        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = newView("index/index");


        System.out.println(new ValuePaths());

        Optional<Record> record = repository.findById("5d5add98ca4adc03a1c5eda0");

        System.out.println(record);

        try {
            mav.addObject("class", PropertyUtils.getProperty(record.get().getExtra(), "test.l2.name"));
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        //        Record record = new Record();
//
//        record.setName("Ivan");
//        record.setExtra(Collections.singletonMap("test",
//            Collections.singletonMap("l2", Collections.singletonMap("name", "MongoDB Viewer"))));
//
//        repository.insert(record);

        return mav;
    }

}
