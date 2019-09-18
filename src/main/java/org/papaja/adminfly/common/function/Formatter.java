package org.papaja.adminfly.common.function;

@FunctionalInterface
public interface Formatter<I, O>{
    O format(I input);
}
