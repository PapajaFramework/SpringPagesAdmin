package org.papaja.adminfly.controller.blog;

import org.papaja.adminfly.dto.blog.CategoryDto;
import org.papaja.adminfly.dto.blog.PostDto;
import org.papaja.adminfly.entity.blog.Category;
import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.mapper.blog.CategoryMapper;
import org.papaja.adminfly.mapper.blog.PostMapper;
import org.papaja.adminfly.service.blog.CategoryService;
import org.papaja.adminfly.service.blog.DomainService;
import org.papaja.adminfly.service.blog.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService posts;

    @Autowired
    private CategoryService categories;

    @Autowired
    private DomainService domains;

    @Autowired
    private CategoryMapper mapper;

    @RequestMapping
    public String redirect() {
        String view = "redirect:/posts/all";

        if (!domains.hasActiveDomain()) {
            view = "redirect:/posts/domains";
        }

        return view;
    }

    @RequestMapping("/domains")
    public ModelAndView domains() {
        ModelAndView view = new ModelAndView();

        view.setViewName("posts/domains");
        view.addObject("domains", domains.getDomains());

        return view;
    }

    @RequestMapping("/domains/select/{id:[0-9]+}")
    public String select(@PathVariable(value = "id", required = false) Integer id) {
        String view = "redirect:/posts";

        domains.setActiveDomain(id);

        return view;
    }

    @RequestMapping("/all")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();

        if (domains.hasActiveDomain()) {
            view.addObject("domain", domains.getActiveDomain());
            view.setViewName("posts/list");
        } else {
            view.setViewName("redirect:/posts/domains");
        }

        return view;
    }

    @RequestMapping(value = {"/create", "/edit/{id:[0-9]+}"})
    public ModelAndView form(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView view   = new ModelAndView("posts/form");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            view.addObject("entity", posts.getPost(id));
            view.addObject("categories", categories.getCategories(domain));
            view.addObject("domain", domain);
        } else {
            view.setViewName("redirect:/posts/domains");
        }

        return view;
    }

    @RequestMapping(value = {"/process"})
    public ModelAndView process(PostMapper mapper, @Valid PostDto dto, BindingResult result) {
        ModelAndView view = new ModelAndView("posts/form");

        if (result.hasErrors()) {
            view.addObject("result", result);
        } else {
            Post post = mapper.map(dto);
            System.out.println(post);
        }

        return view;
    }

    @RequestMapping(value = {"/categories", "/categories/edit/{id:[0-9]+}"})
    public ModelAndView categories(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView view   = new ModelAndView("posts/categories");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            view.addObject("domain", domain);
            view.addObject("categories", categories.getCategories(domain));
            view.addObject("entity", categories.getCategory(id));
        } else {
            view.setViewName("redirect:/posts/domains");
        }

        return view;
    }

    @RequestMapping(value = {"/categories/process/{id:[0-9]+}", "/categories/process"}, method = RequestMethod.POST)
    public ModelAndView process(
        @PathVariable(value = "id", required = false) Integer id, @Valid CategoryDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view     = new ModelAndView("redirect:/posts/categories");
        Category     category = categories.getCategory(id);

        if (domains.hasActiveDomain()) {
            mapper.map(dto, category);
            category.setDomain(domains.getActiveDomain());

            if (result.hasErrors()) {
                attributes.addFlashAttribute("result", result);
            } else {
                attributes.addFlashAttribute("message", String.format("Category '%s' was successfully saved",
                    category.getName()));
                categories.merge(category);
            }

        } else {
            view.setViewName("redirect:/posts/domains");
        }

        return view;
    }

}
