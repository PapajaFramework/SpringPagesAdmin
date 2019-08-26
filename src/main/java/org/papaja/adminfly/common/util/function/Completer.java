package org.papaja.adminfly.common.util.function;

public interface Completer<T> extends Function<T, T> {

    T complete(T value);

    default T apply(T value) {
        return complete(value);
    }

}
