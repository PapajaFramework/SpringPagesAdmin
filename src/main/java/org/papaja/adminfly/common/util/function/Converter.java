package org.papaja.adminfly.common.util.function;

public interface Converter<I, O> extends Function<I, O> {

    default O convert(I input) {
        return apply(input);
    }

}
