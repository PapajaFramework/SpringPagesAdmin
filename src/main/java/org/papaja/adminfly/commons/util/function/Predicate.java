package org.papaja.adminfly.commons.util.function;

import java.util.Objects;

@FunctionalInterface
public interface Predicate<A> {

    boolean test(A a);

    default Predicate<A> and(Predicate<? super A> other) {
        return (a) -> test(a) && other.test(a);
    }

    default Predicate<A> or(Predicate<? super A> other) {
        return (a) -> test(a) || other.test(a);
    }

    default Predicate<A> xor(Predicate<? super A> other) {
        return (a) -> test(a) ^ other.test(a);
    }

    default Predicate<A> isNull() {
        return Objects::isNull;
    }

    default Predicate<A> nonNull() {
        return Objects::nonNull;
    }

    default Predicate<A> negate() {
        return a -> !test(a);
    }

    static <Z> Predicate<Z> not(Predicate<? super Z> predicate) {
        return (Predicate<Z>) predicate.negate();
    }

}
