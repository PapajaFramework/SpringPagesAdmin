package org.papaja.adminfly.commons.util.structure;

import org.papaja.adminfly.commons.util.function.Supplier;

public class ValueSet<T> implements MultiValue<T>, Supplier<T> {

    private T[] values;

    public ValueSet(T... values) {
        this.values = values;
    }

    @Override
    public T get() {
        return asList().get(0);
    }

    @Override
    public T[] asArray() {
        return values;
    }

}
