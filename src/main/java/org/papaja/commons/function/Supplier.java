package org.papaja.commons.function;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}
