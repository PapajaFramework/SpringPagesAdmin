package org.papaja.adminfly.commons.util.function;

@FunctionalInterface
public interface TriFunction<Z, A, B, C> {

    Z apply(A a, B b, C c);

    default <X> TriFunction<X, A, B, C> after(Function<? super Z, ? extends X> after) {
        return (A a, B b, C c) -> after.apply(apply(a, b, c));
    }

}
