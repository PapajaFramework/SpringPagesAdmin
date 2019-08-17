package org.papaja.adminfly.common.util.function;

public interface Consumer<A> {

    void accept(A a);

    default Consumer<A> before(Consumer<? super A> consumer) {
        return (a) -> { consumer.accept(a); accept(a); };
    }

    default Consumer<A> after(Consumer<? super A> consumer) {
        return (a) -> { accept(a); consumer.accept(a); };
    }

}
