package org.papaja.adminfly.common.util;

import org.papaja.adminfly.common.util.function.Converter;

public interface Drawer<I, O> extends Converter<I, O> {

    default O draw(I input) {
        return convert(input);
    }

}
