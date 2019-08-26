package org.papaja.adminfly.common.util.function;

public interface Converter<I, O> {
    O convert(I input);
}
