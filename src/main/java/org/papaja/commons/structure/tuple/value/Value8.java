package org.papaja.commons.structure.tuple.value;

import org.papaja.commons.structure.tuple.getter.ValueH;

public interface Value8<A, B, C, D, E, F, G, H> extends Value7<A, B, C, D, E, F, G>, ValueH<H> {
    default int size() { return 8; }
}
