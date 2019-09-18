package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value2;

public class Pair<A, B> extends
        Unit<A> implements Value2<A, B> {

    protected B b;

    public Pair(A a, B b) {
        super(a); this.b = b;
    }

    @Override
    public B getB() {
        return b;
    }

}
