package org.papaja.adminfly.common.data;

public interface Decoder<S, R> {
    R decode(S source);
}
