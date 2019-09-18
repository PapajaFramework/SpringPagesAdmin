package org.papaja.adminfly.common.function;

public interface BiFunction<Z, A, B> {

    Z apply(A a, B b);

    default <X> BiFunction<X, A, B> after(Function<? super Z, ? extends X> after) {
        return (A a, B b) -> after.apply(apply(a, b));
    }

}
