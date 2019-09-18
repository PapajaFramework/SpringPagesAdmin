package org.papaja.adminfly.common.structure.tuple;

import org.papaja.adminfly.common.structure.tuple.value.Value10;

public class Decade<A, B, C, D, E, F, G, H, I, J>
        extends Ennead<A, B, C, D, E, F, G, H, I>
            implements Value10<A, B, C, D, E, F, G, H, I, J> {

    protected J j;

    public Decade(A a, B b, C c, D d, E e, F f, G g, H h, I i, J j) {
        super(a, b, c, d, e, f, g, h, i);
        this.j = j;
    }

    @Override
    public J getJ() {
        return j;
    }

}
