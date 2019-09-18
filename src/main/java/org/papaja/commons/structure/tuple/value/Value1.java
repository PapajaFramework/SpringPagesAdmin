package org.papaja.commons.structure.tuple.value;

import org.papaja.commons.structure.tuple.getter.ValueA;

public interface Value1<A> extends Tuple, ValueA<A> {
    default int size() { return 1; }
}
