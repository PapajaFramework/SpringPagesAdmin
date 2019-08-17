package org.papaja.adminfly.common.util.function;

@FunctionalInterface
public interface Function<A, R> {

    R apply(A a);

    default <B> Function<B, R> before(Function<? super B, ? extends A> before) {
        return (B b) -> apply(before.apply(b));
    }

    default <B> Function<A, B> after(Function<? super R, ? extends B> after) {
        return (A a) -> after.apply(apply(a));
    }

}
