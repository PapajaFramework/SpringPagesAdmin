package org.papaja.adminfly.module.mdbv.controller;

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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.isNull;

@Controller("mdbvIndexController")
@RequestMapping("/mdbv")
public class IndexController extends AbstractController {

    @Autowired
    private RecordService records;

    @Autowired
    private MdbvValuePathsService paths;

    @Autowired
    private MdbvCollectionService collections;

    @RequestMapping
    public ModelAndView home() {
        return newRedirect("collection");
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/collection")
    public ModelAndView collection(
        @RequestParam(value = "forced", required = false) boolean forced
    ) {
        ModelAndView mav = newView("collection/index");

        mav.addObject("items", collections.getAll());

        if (forced) {
            mav.addObject("message", messages.getErrorMessage("text.accessDenied"));
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/collection/edit/{id}", method = RequestMethod.GET)
    public ModelAndView collectionEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("collection/index");

        mav.addObject("items", collections.getAll());
        mav.addObject("collection", collections.getOne(id));

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/collection/select/{id}", method = RequestMethod.GET)
    public ModelAndView selectCollection(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("collection");

        collections.setActiveCollection(id);
        attributes.addFlashAttribute("message",
            messages.getSuccessMessage("mdbv.access.granted", collections.getActiveCollection().getName()));

        return mav;
    }

    @PreAuthorize("hasAuthority('UPDATE')")
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
        } else {
            collections.save(dto, collections.getOne(id));
            attributes.addFlashAttribute("message", messages.getSuccessMessage("record.saved", "collection"));
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @RequestMapping(value = "/collection/remove/{id}", method = RequestMethod.GET)
    public ModelAndView collectionRemove(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("collection");

        collections.remove(id);
        attributes.addFlashAttribute("message",
            messages.getSuccessMessage("record.removed.id", messages.getMessage("label.collection"), id));

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/routing")
    public ModelAndView routing() {
        ModelAndView mav = newView("routing/index");

        if (collections.hasActiveCollection()) {
            mav.addObject("items", paths.getPaths(collections.getActiveCollection()));
            mav.addObject("types", MdbvValuePath.Type.values());
        } else {
            mav = newRedirect("collection?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/routing/edit/{id}", method = RequestMethod.GET)
    public ModelAndView routingEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("routing/index");

        if (collections.hasActiveCollection()) {
            mav.addObject("path", paths.getPath(id));
            mav.addObject("items", paths.getPaths());
            mav.addObject("types", MdbvValuePath.Type.values());
        } else {
            mav = newRedirect("collection?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @RequestMapping(value = "/routing/remove/{id}", method = RequestMethod.GET)
    public ModelAndView routingRemove(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("routing");

        if (collections.hasActiveCollection()) {
            paths.remove(id);
            attributes.addFlashAttribute("message", messages.getSuccessMessage("record.removed.id", "path", id));
        } else {
            mav = newRedirect("collection?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @RequestMapping(value = {
        "/routing/edit/{id}", "/routing/edit"
    }, method = RequestMethod.POST)
    public ModelAndView routingSave(
        @PathVariable(required = false) Integer id, @Valid ValuePathDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("routing");

        if (collections.hasActiveCollection()) {
            if (result.hasErrors()) {
                attributes.addFlashAttribute("result", result);
                attributes.addFlashAttribute("path", dto);
            } else {
                paths.save(dto, paths.getPathOrNew(id));
            }
        } else {
            mav = newRedirect("collection?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/records")
    public ModelAndView records(
        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page
    ) {
        ModelAndView    mav        = newView("records/index");
        List<MapRecord> records    = this.records.getRecords(page - 1);
        PaginationData  pagination = new PaginationData(this.records.count(), page, RecordService.DEFAULT_SIZE);

        if (collections.hasActiveCollection()) {
            mav.addObject("pagination", pagination);
            mav.addObject("records", records);
        } else {
            mav = newRedirect("collection?forced=1");
        }

        return mav;
    }

}
