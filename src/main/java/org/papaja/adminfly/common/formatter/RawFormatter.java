package org.papaja.adminfly.common.formatter;

import org.papaja.adminfly.common.util.Formatter;

import java.util.Objects;

public class RawFormatter implements Formatter<Object, String> {

    @Override
    public String format(Object object) {
        return Objects.toString(object);
    }

}
