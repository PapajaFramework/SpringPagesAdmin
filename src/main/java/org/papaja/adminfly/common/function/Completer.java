package org.papaja.adminfly.common.function;

public interface Completer<T> extends Function<T, T> {

    T complete(T value);

    default T apply(T value) {
        return complete(value);
    }

}
