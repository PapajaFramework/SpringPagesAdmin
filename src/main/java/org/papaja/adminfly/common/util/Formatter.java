package org.papaja.adminfly.common.util;

import org.papaja.adminfly.common.util.function.Converter;

public interface Formatter<I, O> extends Converter<I, O> {

    O format(I input);

    default O convert(I input) {
        return format(input);
    }

}
