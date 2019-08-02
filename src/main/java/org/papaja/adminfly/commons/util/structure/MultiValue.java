package org.papaja.adminfly.commons.util.structure;

import java.util.List;

public interface MultiValue<T> {

    List<T> asList();

    T[] asArray();

}
