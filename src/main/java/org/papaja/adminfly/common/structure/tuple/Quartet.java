package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value4;

public class Quartet<A, B, C, D> extends
        Triplet<A, B, C> implements Value4<A, B, C, D> {

    protected D d;

    public Quartet(A a, B b, C c, D d) {
        super(a, b, c); this.d = d;
    }

    @Override
    public D getD() {
        return d;
    }

}
