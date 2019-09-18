package org.papaja.commons.function;

public interface Completer<T> extends Function<T, T> {

    T complete(T value);

    default T apply(T value) {
        return complete(value);
    }

}
