package org.papaja.adminfly.common.converter;

public interface Decoder<S, R> {
    R decode(S source);
}
