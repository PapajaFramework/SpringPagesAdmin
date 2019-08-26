package org.papaja.adminfly.common.converter;

public interface Encoder<S, R> {
    R encode(S source);
}
