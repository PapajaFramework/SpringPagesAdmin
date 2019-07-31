package org.papaja.adminfly.commons.util.function;

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

    default Predicate<A> negate() {
        return a -> !test(a);
    }

    static <Z> Predicate<Z> not(Predicate<? super Z> predicate) {
        return (Predicate<Z>) predicate.negate();
    }

}
