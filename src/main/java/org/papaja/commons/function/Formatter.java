package org.papaja.commons.function;

@FunctionalInterface
public interface Formatter<I, O>{
    O format(I input);
}
