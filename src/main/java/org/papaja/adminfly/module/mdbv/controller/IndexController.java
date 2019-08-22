package org.papaja.adminfly.module.mdbv.controller;

import org.papaja.adminfly.module.mdbv.common.holder.MdbvCollectionNameHolder;
import org.papaja.adminfly.module.mdbv.mongodb.data.PaginationData;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mongodb.service.RecordService;
import org.papaja.adminfly.module.mdbv.mysql.dto.CollectionDto;
import org.papaja.adminfly.module.mdbv.mysql.dto.ValuePathDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.MdbvValuePath;
import org.papaja.adminfly.module.mdbv.mysql.service.MdbvCollectionService;
import org.papaja.adminfly.module.mdbv.mysql.service.MdbvValuePathsService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@Controller("wsaIndex")
@RequestMapping("/mdbv")
public class IndexController extends AbstractController {

    @Autowired
    private RecordService records;

    @Autowired
    private MdbvValuePathsService paths;

    @Autowired
    private MdbvCollectionService collections;

    @Autowired
    private MdbvCollectionNameHolder holder;

    @RequestMapping
    public RedirectView home() {
        return newRedirectView("index");
    }

    @RequestMapping("/collection")
    public ModelAndView collection() {
        ModelAndView mav = newView("collection/index");

        mav.addObject("items", collections.getAll());

        return mav;
    }

    @RequestMapping(value = "/collection/edit/{id}", method = RequestMethod.GET)
    public ModelAndView collectionEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("collection/index");

        mav.addObject("items", collections.getAll());
        mav.addObject("collection", collections.getOne(id));

        return mav;
    }

    @RequestMapping(value = {
            "/collection/edit/{id}", "/collection/edit"
    }, method = RequestMethod.POST)
    public ModelAndView collectionSave(
        @PathVariable(required = false) Integer id, @Valid CollectionDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect(isNull(id) ? "collection" : format("collection/edit/%d", id));

        if (result.hasErrors()) {
            attributes.addFlashAttribute("result", result);
            attributes.addFlashAttribute("collection", dto);
        }

        System.out.println(dto);

        return mav;
    }

    @RequestMapping("/routing")
    public ModelAndView routing() {
        ModelAndView mav = newView("routing/index");

        mav.addObject("items", paths.getPaths());
        mav.addObject("types", MdbvValuePath.Type.values());

        return mav;
    }

    @RequestMapping(value = "/routing/edit/{id}", method = RequestMethod.GET)
    public ModelAndView routingEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("routing/index");

        mav.addObject("path", paths.getPath(id));
        mav.addObject("items", paths.getPaths());
        mav.addObject("types", MdbvValuePath.Type.values());

        return mav;
    }

    @RequestMapping(value = {"/routing/edit/{id}", "/routing/edit"}, method = RequestMethod.POST)
    public RedirectView routingSave(
        @PathVariable(required = false) Integer id, @Valid ValuePathDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        RedirectView redirect = newRedirectView("routing");

        if (result.hasErrors()) {
            attributes.addFlashAttribute("result", result);
            attributes.addFlashAttribute("path", dto);
        } else {
            paths.save(dto, paths.getPathOrNew(id));
        }

        return redirect;
    }

    @RequestMapping("/records")
    public ModelAndView records(
        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
    ) {
        ModelAndView    mav        = newView("records/index");
        List<MapRecord> records    = this.records.getRecords(page - 1);
        PaginationData  pagination = new PaginationData(this.records.count(), page, RecordService.DEFAULT_SIZE);

        mav.addObject("pagination", pagination);
        mav.addObject("records", records);

        System.out.println(holder.has());

        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = newView("index/index");

        mav.addObject("class", getClass().getName());

        return mav;
    }

}
