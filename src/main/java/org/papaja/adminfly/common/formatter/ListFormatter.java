package org.papaja.adminfly.common.formatter;

import org.papaja.adminfly.common.util.Formatter;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class ListFormatter implements Formatter<List<?>, String> {

    @Override
    public String format(List<?> objects) {
        return String.format("[%s]", join(", ", objects.stream().map(Object::toString).collect(Collectors.toList())));
    }

}
