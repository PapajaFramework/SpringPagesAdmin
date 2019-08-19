package org.papaja.adminfly.common.util.function;

public interface Completer<T> extends Function<T, T> {

    default T complete(T t) {
        return apply(t);
    }

}
