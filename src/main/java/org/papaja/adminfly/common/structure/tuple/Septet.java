package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value7;

public class Septet<A, B, C, D, E, F, G>
        extends Sextet<A, B, C, D, E, F> implements Value7<A, B, C, D, E, F, G> {

    protected G g;

    public Septet(A a, B b, C c, D d, E e, F f, G g) {
        super(a, b, c, d, e, f); this.g = g;
    }

    @Override
    public G getG() {
        return g;
    }

}
