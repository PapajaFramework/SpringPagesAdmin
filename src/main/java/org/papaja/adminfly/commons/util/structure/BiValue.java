package org.papaja.adminfly.commons.util.structure;

import java.util.Arrays;
import java.util.List;

public class BiValue<A, B> implements MultiValue<Object> {

    private A a;
    private B b;

    public BiValue(A a, B b) {
        this.a = a;
        this.b = b;
    }

    public A getA() {
        return a;
    }

    public B getB() {
        return b;
    }

    @Override
    public List<Object> asList() {
        return Arrays.asList(a, b);
    }

    @Override
    public Object[] asArray() {
        return new Object[]{a, b};
    }

    @Override
    public String toString() {
        return String.format("%s{a='%s', b='%s'}", getClass().getSimpleName(), a, b);
    }

}
