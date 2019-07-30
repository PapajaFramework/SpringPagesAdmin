package org.papaja.adminfly.commons.util.function;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

@FunctionalInterface
public interface TriConsumer<A, B, C> {

    void accept(A a, B b, C c);

    default TriConsumer<A, B, C> before(TriConsumer<? super A, ? super B, ? super C> consumer) {
        requireNonNull(consumer, format("Consumer cannot be NULL for %s#before()", getClass().getName()));

        return (a, b, c) -> { consumer.accept(a, b, c); accept(a, b, c); };
    }

    default TriConsumer<A, B, C> after(TriConsumer<? super A, ? super B, ? super C> consumer) {
        requireNonNull(consumer, format("Consumer cannot be NULL for %s#after()", getClass().getName()));

        return (a, b, c) -> { accept(a, b, c); consumer.accept(a, b, c); };
    }

}
