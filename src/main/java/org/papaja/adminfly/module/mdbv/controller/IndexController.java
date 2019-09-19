package org.papaja.adminfly.module.mdbv.controller;

import org.papaja.adminfly.module.mdbv.dto.Filter;
import org.papaja.adminfly.module.mdbv.mongodb.data.query.FilterTuple;
import org.papaja.commons.data.pagination.PaginationData;
import org.papaja.adminfly.module.mdbv.mongodb.record.MapRecord;
import org.papaja.adminfly.module.mdbv.mongodb.service.RecordService;
import org.papaja.adminfly.module.mdbv.mysql.dto.RowDto;
import org.papaja.adminfly.module.mdbv.mysql.dto.SourceDto;
import org.papaja.adminfly.module.mdbv.mysql.entity.Row;
import org.papaja.adminfly.module.mdbv.mysql.entity.Source;
import org.papaja.adminfly.module.mdbv.mysql.service.RowService;
import org.papaja.adminfly.module.mdbv.mysql.service.SourceService;
import org.papaja.adminfly.shared.controller.AbstractController;
import org.papaja.commons.converter.Coders;
import org.papaja.commons.converter.Format;
import org.papaja.commons.converter.coder.QuotedStringCoder;
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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static org.papaja.commons.converter.Format.STRING;
import static org.springframework.util.StringUtils.hasText;

@Controller("mdbvIndexController")
@RequestMapping("/mdbv")
@SuppressWarnings({"unused"})
public class IndexController extends AbstractController {

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
    public ModelAndView records(
        @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
        @RequestParam(value = "query", required = false) String queryString,
        @RequestParam(value = "path", required = false) String queryPath,
        @RequestParam(value = "type", required = false) String queryType,
        @RequestParam(value = "rule", required = false) String queryRule
    ) {
        ModelAndView mav = newView("records/index");

        if (sources.hasActiveSource()) {
            Query   query;
            Source  source        = sources.getActiveSource();
            boolean hasFilterData = (hasText(queryRule) && hasText(queryPath) && hasText(queryType));

            if (hasFilterData) {
                query = this.records.getQuery(
                        queryPath, Format.valueOf(queryType), queryString, Operator.Comparison.valueOf(queryRule),
                        page - 1, RecordService.DEFAULT_SIZE
                );
            } else {
                query = this.records.getQuery(page - 1, RecordService.DEFAULT_SIZE);
            }

            mav.addObject("pagination", new PaginationData(this.records.count(query), page, RecordService.DEFAULT_SIZE));
            mav.addObject("rows", rows.getSortedRows());
            mav.addObject("records", this.records.getRecords(sources.getActiveSource().getCollection(), query));
            mav.addObject("formats", Format.values());
            mav.addObject("filters", Operator.Comparison.values());
            mav.addObject("activeSource", sources.getActiveSource());
            mav.addObject("preview", rows.getPreviewRows());
            mav.addObject("coders", Coders.INSTANCE);
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

            ((QuotedStringCoder)Coders.INSTANCE.get(STRING)).setBraces("'", "'");

            mav.addObject("jsonRecord", records.getJsonRecord(objectId));
            mav.addObject("record", record);
            mav.addObject("accessor", new MapPathAccessor());
            mav.addObject("coders", Coders.INSTANCE);
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
