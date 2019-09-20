package org.papaja.adminfly.module.mdbv.controller;

import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.FilterTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.PageTuple;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.tuple.SortTuple;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mongodb.service.RecordService;
import org.papaja.adminfly.module.mdbv.mysql.dto.RowDto;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourceDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.papaja.adminfly.module.mdbv.mysql.service.RowService;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.papaja.commons.converter.Format;
import org.papaja.commons.converter.coder.StringCoder;
import org.papaja.commons.data.pagination.Paging;
import org.papaja.commons.data.query.Operator;
import org.papaja.commons.util.MapPathAccessor;
import org.papaja.commons.util.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.PersistenceException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.papaja.commons.converter.Coders.INSTANCE;
import static org.papaja.commons.converter.Format.STRING;
import static org.papaja.commons.converter.coder.StringCoder.SQUARE_BRACES;

@Controller("mdbvIndexController")
@RequestMapping("/mdbv")
@SuppressWarnings({"unused"})
public class IndexController extends AbstractController {

    static {
        ((StringCoder) INSTANCE.get(STRING)).setBraces(SQUARE_BRACES);
    }

    @Autowired
    private RecordService records;

    @Autowired
    private SourceService sources;

    @Autowired
    private RowService rows;

    @Autowired
    private ServletContext context;

    @Autowired
    private HttpServletRequest request;

    @Value("${module.name}")
    private String name;

    @ModelAttribute
    public void addAttributes(ModelAndView model) {
        model.addObject("name", name);
    }

    @RequestMapping
    public ModelAndView home() {
        return newRedirect("sources");
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/sources")
    public ModelAndView sources(
        @RequestParam(value = "forced", required = false) boolean forced
    ) {
        ModelAndView mav = newView("sources/index");

        mav.addObject("items", sources.getAll());
        mav.addObject("activeSource", sources.getActiveSource());

        if (forced) {
            mav.addObject("message", messages.getErrorMessage("text.accessDenied"));
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/sources/edit/{id}", method = RequestMethod.GET)
    public ModelAndView sourcesEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("sources/index");

        mav.addObject("items", sources.getAll());
        mav.addObject("source", sources.getOne(id));

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/sources/select/{id}", method = RequestMethod.GET)
    public ModelAndView selectSources(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("records");

        sources.setActiveSource(id);
        attributes.addFlashAttribute("message",
            messages.getSuccessMessage("mdbv.access.granted", sources.getActiveSource().getName()));

        return mav;
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @RequestMapping(value = {
            "/sources/edit/{id}", "/sources/edit"
    }, method = RequestMethod.POST)
    public ModelAndView sourcesSave(
        @PathVariable(required = false) Integer id, @Valid SourceDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect(isNull(id) ? "sources" : format("sources/edit/%d", id));

        if (result.hasErrors()) {
            attributes.addFlashAttribute("result", result);
            attributes.addFlashAttribute("sources", dto);
        } else {
            sources.save(dto, sources.getOne(id));
            attributes.addFlashAttribute("message", messages.getSuccessMessage("record.saved", "sources"));
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @RequestMapping(value = "/sources/remove/{id}", method = RequestMethod.GET)
    public ModelAndView sourcesRemove(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("sources");

        sources.remove(id);
        attributes.addFlashAttribute("message",
            messages.getSuccessMessage("record.removed.id", messages.getMessage("label.source"), id));

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/rows")
    public ModelAndView rows() {
        ModelAndView mav = newView("rows/index");

        if (sources.hasActiveSource()) {
            mav.addObject("activeSource", sources.getActiveSource());
            mav.addObject("items", rows.getRows());
            mav.addObject("types", Format.values());
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = "/rows/edit/{id}", method = RequestMethod.GET)
    public ModelAndView rowsEdit(@PathVariable Integer id) {
        ModelAndView mav = newView("rows/index");

        if (sources.hasActiveSource()) {
            mav.addObject("activeSource", sources.getActiveSource());
            mav.addObject("row", rows.getOne(id));
            mav.addObject("items", rows.getRows());
            mav.addObject("types", Format.values());
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('REMOVE')")
    @RequestMapping(value = "/rows/remove/{id}", method = RequestMethod.GET)
    public ModelAndView rowsRemove(
        @PathVariable Integer id, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("rows");

        if (sources.hasActiveSource()) {
            rows.remove(id);
            attributes.addFlashAttribute("message", messages.getSuccessMessage("record.removed.id", "path", id));
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @RequestMapping(value = {
        "/rows/edit/{id}", "/rows/edit"
    }, method = RequestMethod.POST)
    public ModelAndView rowsSave(
        @PathVariable(required = false) Integer id, @Valid RowDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView mav = newRedirect("rows");

        if (sources.hasActiveSource()) {
            if (result.hasErrors()) {
                attributes.addFlashAttribute("result", result);
                attributes.addFlashAttribute("row", dto);
            } else {
                rows.save(dto, rows.getOne(id));
            }
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/records")
    public ModelAndView records(FilterTuple filter, SortTuple sort, PageTuple page) {
        ModelAndView mav = newView("records/index");

        System.out.println(page);
        System.out.println(filter);
        System.out.println(sort);

        if (sources.hasActiveSource()) {
            Query  query  = records.getQuery(filter, page, sort);
            Source source = sources.getActiveSource();

            System.out.println(query.getQueryObject().toJson());
            System.out.println(query.getSortObject().toJson());

            // rows
            mav.addObject("rows", rows.getSortedRows());
            mav.addObject("preview", rows.getPreviewRows());
            // records
            mav.addObject("records", records.getRecords(sources.getActiveSource().getCollection(), query));
            mav.addObject("pagination", new Paging(records.count(query), page.getPage(), PageTuple.DEFAULT_COUNT));
            // additional
            mav.addObject("formats", Format.values());
            mav.addObject("filters", Operator.Comparison.values());
            mav.addObject("source", sources.getActiveSource());
            mav.addObject("coders", INSTANCE);
            mav.addObject("accessor", new MapPathAccessor());
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/records/view/{objectId:[\\w\\d.\\-]+}")
    public ModelAndView recordView(
        @PathVariable(name = "objectId", required = false) String objectId
    ) {
        ModelAndView mav = newView("records/view");

        if (sources.hasActiveSource()) {
            MapRecord               record   = records.getRecord(objectId);

            mav.addObject("jsonRecord", records.getJsonRecord(objectId));
            mav.addObject("record", record);
            mav.addObject("accessor", new MapPathAccessor());
            mav.addObject("coders", INSTANCE);
            mav.addObject("rows", this.rows.getSortedRows());
            mav.addObject("source", sources.getActiveSource());
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

    @PreAuthorize("hasAuthority('SECURITY')")
    @RequestMapping("/scan")
    public ModelAndView scan(RedirectAttributes attributes) {
        ModelAndView mav = newRedirect("records");

        if (sources.hasActiveSource()) {
            Set<String> paths      = new HashSet<>();
            int[]       counter    = new int[]{0};
            String      collection = sources.getActiveSource().getCollection();

            for (MapRecord record : records.getRecords(collection, new Query())) {
                paths.addAll(MapUtils.getPaths(record));
            }

            counter[0] = paths.size();

            paths.forEach(path -> {
                try {
                    Row row = rows.get();

                    row.setPosition(0);
                    row.setType(Format.RAW);
                    row.setPath(path);
                    row.setSource(sources.getActiveSource());
                    row.setStatus(Row.Status.S);

                    rows.merge(row);
                } catch (PersistenceException exception) {
                    counter[0]--;
                }
            });

            attributes.addFlashAttribute("message",
                    messages.getSuccessMessage("mdbv.mongodb.scanned", collection, paths.size(), counter[0]));
        } else {
            mav = newRedirect("sources?forced=1");
        }

        return mav;
    }

}
