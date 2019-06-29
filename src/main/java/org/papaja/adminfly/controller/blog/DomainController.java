package org.papaja.adminfly.controller.blog;

import org.papaja.adminfly.dto.blog.DomainDto;
import org.papaja.adminfly.entity.blog.Domain;
import org.papaja.adminfly.mapper.blog.DomainMapper;
import org.papaja.adminfly.service.blog.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/domains")
@Secured("ROLE_ADMIN")
public class DomainController {

    @Autowired
    private DomainService domains;

    @Autowired
    private DomainMapper mapper;

    @RequestMapping(value = {"/{id:[0-9]+}", "/all"}, method = RequestMethod.GET)
    public String domains(
        @PathVariable(value = "id", required = false) Integer id, Model model
    ) {
        model.addAttribute("domains", domains.getDomains());
        model.addAttribute("entity", domains.getDomain(id));

        return "domains/list";
    }

    @RequestMapping(value = {"/{id:[0-9]+}"}, method = RequestMethod.POST)
    public ModelAndView process(
        @PathVariable(value = "id") Integer id, @Valid DomainDto dto, BindingResult result,
        RedirectAttributes attributes
    ) {
        ModelAndView view = new ModelAndView("redirect:/domains/all");

        System.out.println(dto);

        if (!result.hasErrors()) {
            attributes.addFlashAttribute("message",
                String.format("Domain '%s' was successfully saved", dto.getDomain()));
        } else {
            view.addObject("result", result);
            view.setViewName("domains/list");
        }

        return view;
    }

}
