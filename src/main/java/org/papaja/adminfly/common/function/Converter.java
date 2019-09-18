package org.papaja.adminfly.common.function;

@FunctionalInterface
public interface Converter<I, O> {
    O convert(I input);
}
