package org.papaja.adminfly.common.detector;

import java.util.Objects;
import java.util.function.Supplier;

public interface Revisor<V> extends Supplier<V> {

    default boolean has() {
        return Objects.nonNull(get());
    }

}
