package org.papaja.commons.converter;

public interface Encoder<S, R> {
    R encode(S source);
}
