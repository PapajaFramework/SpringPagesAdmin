package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value6;

public class Sextet<A, B, C, D, E, F> extends
        Quintet<A, B, C, D, E> implements Value6<A, B, C, D, E, F> {

    protected F f;

    public Sextet(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e); this.f = f;
    }

    @Override
    public F getF() {
        return f;
    }

}
