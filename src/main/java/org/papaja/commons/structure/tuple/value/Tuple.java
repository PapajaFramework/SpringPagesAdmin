package org.papaja.commons.structure.tuple.value;

public interface Tuple {

    int SIZE = -1;

    default int size() {
        return SIZE;
    }

}
