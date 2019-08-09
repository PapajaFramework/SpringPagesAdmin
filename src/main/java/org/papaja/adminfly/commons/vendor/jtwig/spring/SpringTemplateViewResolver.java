package org.papaja.adminfly.commons.vendor.jtwig.spring;

import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;

public class SpringTemplateViewResolver extends JtwigViewResolver {

    @Override
    protected JtwigView buildView(String name) throws Exception {
        return super.buildView(resolveViewName(name));
    }

    protected String resolveViewName(String name) {
        return name.startsWith("/") ? name.substring(1) : name;
    }

}
