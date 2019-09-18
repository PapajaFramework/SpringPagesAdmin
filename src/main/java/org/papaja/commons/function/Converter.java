package org.papaja.commons.function;

@FunctionalInterface
public interface Converter<I, O> {
    O convert(I input);
}
