package org.papaja.adminfly.common.coder;

public interface Decoder<R> {

    R decode(byte[] bytes);

    default R decode(String value) {
        return decode(value.getBytes());
    }

}
