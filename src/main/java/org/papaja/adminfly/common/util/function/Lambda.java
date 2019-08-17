package org.papaja.adminfly.common.util.function;

@SuppressWarnings({"unused"})
final public class Lambda {

    public static <A> Predicate<A> as(Predicate<A> predicate) {
        return predicate;
    }

    public static <A> Consumer<A> as(Consumer<A> consumer) {
        return consumer;
    }

    public static <A> Supplier<A> as(Supplier<A> supplier) {
        return supplier;
    }

    public static <A, Z> Function<A, Z> as(Function<A, Z> function) {
        return function;
    }

    public static <A, B, C, Z> TriFunction<A, B, C, Z> as(TriFunction<A, B, C, Z> function) {
        return function;
    }

    public static <A, B, C> TriConsumer<A, B, C> as(TriConsumer<A, B, C> consumer) {
        return consumer;
    }

}
