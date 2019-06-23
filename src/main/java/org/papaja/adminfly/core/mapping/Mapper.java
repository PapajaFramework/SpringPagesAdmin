package org.papaja.adminfly.core.mapping;

import java.util.function.Supplier;

public interface Mapper<S, T> extends Supplier<T> {

    default T map(S source) {
        T target = get();

        map(source, target);

        return target;
    }

    void map(S source, T target);

}
