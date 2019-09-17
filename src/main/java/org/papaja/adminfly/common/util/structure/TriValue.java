package org.papaja.adminfly.common.util.structure;

public class TriValue<A, B, C> extends BiValue<A, B> {

    private C c;

    public TriValue(A a, B b, C c) {
        super(a, b); this.c = c;
    }

    public C getC() {
        return c;
    }

    @Override
    public Object[] asArray() {
        return new Object[]{getA(), getB(), c};
    }

    @Override
    public String toString() {
        return String.format("%s{parent='%s', c='%s'}", getClass().getSimpleName(), super.toString(), c);
    }

}
