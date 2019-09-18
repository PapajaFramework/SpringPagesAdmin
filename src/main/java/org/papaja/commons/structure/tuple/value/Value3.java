package org.papaja.commons.structure.tuple.value;

import org.papaja.commons.structure.tuple.getter.ValueC;

public interface Value3<A, B, C> extends Value2<A, B>, ValueC<C> {

    int SIZE = 3;

}
