package org.papaja.adminfly.common.util.structure;

import org.papaja.adminfly.common.util.function.Supplier;

import static java.util.Objects.nonNull;

public interface Holder<V> extends Supplier<V> {

    default boolean has() {
        return nonNull(get());
    }

    void set(V value);

}
