package org.papaja.adminfly.controller.blog;

import org.papaja.adminfly.controller.AbstractController;
import org.papaja.adminfly.dto.blog.CategoryDto;
import org.papaja.adminfly.dto.blog.DomainDto;
import org.papaja.adminfly.dto.blog.PostDto;
import org.papaja.adminfly.entity.blog.Category;
import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.entity.blog.Post;
import org.papaja.adminfly.mapper.blog.CategoryMapper;
import org.papaja.adminfly.mapper.blog.DomainMapper;
import org.papaja.adminfly.mapper.blog.PostMapper;
import org.papaja.adminfly.service.blog.CategoryService;
import org.papaja.adminfly.service.blog.DomainService;
import org.papaja.adminfly.service.blog.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@SuppressWarnings({"unused"})
@Controller
@RequestMapping("/blog")
public class BlogController extends AbstractController {

    private static final String TO_SELECT_DOMAIN          = "/setting/selectDomain";
    private static final String REDIRECT_TO_SELECT_DOMAIN = "redirect:/blog" + TO_SELECT_DOMAIN;

    @Autowired
    private PostService     posts;

    @Autowired
    private CategoryService categories;

    @Autowired
    private DomainService   domains;

    @Autowired
    private CategoryMapper  categoryMapper;

    @Autowired
    private DomainMapper    domainMapper;

    @RequestMapping
    public String redirect() {
        String view = "redirect:/blog/posts";

        if (!domains.hasActiveDomain()) {
            view = REDIRECT_TO_SELECT_DOMAIN;
        }

        return view;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/posts")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page) {
        ModelAndView view = new ModelAndView();

        if (domains.hasActiveDomain()) {
            view.addObject("domain", domains.getActiveDomain());
            view.addObject("result", posts.getPosts(page));
            view.setViewName("blog/posts/list");
        } else {
            view.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return view;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/posts/create", "/posts/edit/{id:[0-9]+}"})
    public ModelAndView form(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView view   = new ModelAndView("blog/posts/form");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            view.addObject("entity", posts.getPost(id));
            view.addObject("categories", categories.getCategories(domain));
            view.addObject("domain", domain);
        } else {
            view.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return view;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/posts/process"})
    public ModelAndView process(PostMapper mapper, @Valid PostDto dto, BindingResult result) {
        ModelAndView view   = newView("posts/form");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            if (result.hasErrors()) {
                view.addObject("result", result);
                view.addObject("entity", dto);
                view.addObject("categories", categories.getCategories(domain));
            } else {
                Post post = posts.getPost(dto.getId());
                mapper.map(dto, post);

                post.setCategory(categories.getCategory(dto.getCategoryId()));
                post.setDomain(domains.getDomain(domain.getId()));

                posts.merge(post);

                if (post.isNew()) {
                    view.setViewName("redirect:/blog/posts");
                } else {
                    view.setViewName(String.format("redirect:/blog/posts/edit/%d", post.getId()));
                }
            }
        } else {
            view.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return view;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/categories", "/categories/edit/{id:[0-9]+}"})
    public ModelAndView categories(@PathVariable(value = "id", required = false) Integer id) {
        ModelAndView view   = newView("categories/categories");
        Domain       domain = domains.getActiveDomain();

        if (domains.hasActiveDomain()) {
            view.addObject("domain", domain);
            view.addObject("categories", categories.getCategories(domain));
            view.addObject("entity", categories.getCategory(id));
        } else {
            view.setViewName(REDIRECT_TO_SELECT_DOMAIN);
        }

        return view;
    }

    @PreAuthorize("hasAnyAuthority('CREATE', 'UPDATE')")
    @RequestMapping(value = {"/categories/process/{id:[0-9]+}", "/categories/process"}, method = RequestMethod.POST)
    public RedirectView process(
        @PathVariable(value = "id", required = false) Integer id, @Valid CategoryDto dto,
        BindingResult result, RedirectAttributes attributes
    ) {
        RedirectView view     = newRedirect("categories");
        Category     category = categories.getCategory(id);

        if (domains.hasActiveDomain()) {
            categoryMapper.map(dto, category);
            category.setDomain(domains.getActiveDomain());

            if (result.hasErrors()) {
                attributes.addFlashAttribute("result", result);
            } else {
                attributes.addFlashAttribute("message", getMessage("blog.category.saved", category.getName()));
                categories.merge(category);
            }

        } else {
            view.setUrl(TO_SELECT_DOMAIN);
        }

        return view;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping(value = {"/setting/domains/{id:[0-9]+}", "/setting/domains"}, method = RequestMethod.GET)
    public ModelAndView domains(
        @PathVariable(value = "id", required = false) Integer id, Model model
    ) {
        model.addAttribute("domains", domains.getDomains());
        model.addAttribute("entity", domains.getDomain(id));

        return newView("setting/domains");
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERUSER')")
    @RequestMapping(value = {"/setting/domains/{id:[0-9]+}", "/setting/domains"}, method = RequestMethod.POST)
    public ModelAndView process(
        @PathVariable(value = "id", required = false) Integer id, @Valid DomainDto dto, BindingResult result, RedirectAttributes attributes
    ) {
        ModelAndView view   = newView("setting/domains");
        Domain       domain = domains.getDomain(id);

        domainMapper.map(dto, domain);

        if (!result.hasErrors()) {
            domains.merge(domain);
            attributes.addFlashAttribute("message", getMessage("blog.domain.saved", domain.getDomain(), domain.getName()));
            view.setViewName("redirect:/blog/setting/domains");
        } else {
            view.addObject("entity", domain);
            view.addObject("domains", domains.getDomains());
            view.addObject("result", result);
        }

        return view;
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting/selectDomain/{id:[0-9]+}")
    public String select(@PathVariable(value = "id", required = false) Integer id) {
        domains.setActiveDomain(id);

        System.out.println("------");
        System.out.println(domains.getActiveDomain().getUsers());
        System.out.println("------");

        // todo: need to block by domain

        return "redirect:/blog/posts";
    }

    @PreAuthorize("hasAuthority('READ')")
    @RequestMapping("/setting/selectDomain")
    public ModelAndView domains() {
        ModelAndView view = newView("setting/selectDomain");

        view.addObject("domains", domains.getDomains());

        return view;
    }

    @RequestMapping("/setting/permissions")
    public ModelAndView permissions() {
        ModelAndView mav = newView("setting/permissions");

        return mav;
    }

}
