package org.papaja.adminfly.commons.util.structure;

import java.util.Arrays;
import java.util.List;

public interface MultiValue<T> {

    default List<T> asList() {
        return Arrays.asList(asArray());
    }

    T[] asArray();

}
