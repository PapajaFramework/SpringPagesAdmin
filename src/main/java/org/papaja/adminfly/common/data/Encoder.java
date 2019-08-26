package org.papaja.adminfly.common.data;

public interface Encoder<S, R> {
    R encode(S source);
}
