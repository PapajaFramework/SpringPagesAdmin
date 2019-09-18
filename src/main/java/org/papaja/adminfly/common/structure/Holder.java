package org.papaja.adminfly.common.structure;

import org.papaja.adminfly.common.function.Supplier;

import static java.util.Objects.nonNull;

public interface Holder<V> extends Supplier<V> {

    default boolean has() {
        return nonNull(get());
    }

    default boolean notHas() {
        return !has();
    }

    void set(V value);

}
