package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value5;

public class Quintet<A, B, C, D, E> extends
        Quartet<A, B, C, D> implements Value5<A, B, C, D, E> {

    protected E e;

    public Quintet(A a, B b, C c, D d, E e) {
        super(a, b, c, d); this.e = e;
    }

    @Override
    public E getE() {
        return e;
    }

}
