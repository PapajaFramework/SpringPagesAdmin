package org.papaja.adminfly.shared.vendor.jtwig.spring;

import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;

import java.nio.file.NoSuchFileException;
import java.util.*;

import static java.lang.String.format;

@SuppressWarnings({"unused"})
public class MultipleTemplateViewResolver extends JtwigViewResolver {

    @Autowired
    private ResourceLoader loader;
    private Set<String>    prefixes;

    public MultipleTemplateViewResolver(String... prefixes) {
        this.prefixes = new LinkedHashSet<>(Arrays.asList(prefixes));
        this.prefixes.add("");
    }

    @Override
    protected JtwigView buildView(String name) throws Exception {
        Iterator<String> iterator = prefixes.iterator();

        while (iterator.hasNext()) {
            String viewName = resolveViewName(name, iterator.next());
            String location = getViewLocation(viewName);

            if (isExistView(location)) {
                return super.buildView(viewName);
            }
        }

        throw new NoSuchFileException(name);
    }

    protected String getViewLocation(String name) {
        return format("%s%s%s", getPrefix(), name, getSuffix());
    }

    protected String resolveViewName(String name, String prefix) {
        return prefix + resolveViewName(name);
    }

    protected String resolveViewName(String name) {
        return name.startsWith("/") ? name.substring(1) : name;
    }

    protected boolean isExistView(String location) {
        return loader.getResource(location).exists();
    }


}
