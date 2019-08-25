package org.papaja.adminfly.common.util.drawer;

import org.papaja.adminfly.common.util.Drawer;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.lang.String.join;

public class ListDrawer implements Drawer<List<?>, String> {

    @Override
    public String apply(List<?> objects) {
        return format("[%s]", join(", ", objects.stream().map(Object::toString).collect(Collectors.toList())));
    }

}
