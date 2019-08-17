package org.papaja.adminfly.common.util.function;

@FunctionalInterface
public interface VariadicFunction<A, Z> {

    Z apply(A... value);

    default <B> VariadicFunction<A, B> after(Function<? super Z, ? extends B> after) {
        return (A... a) -> after.apply(apply(a));
    }

}
