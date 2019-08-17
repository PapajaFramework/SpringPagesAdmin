package org.papaja.adminfly.common.security;

public interface Encoder<R> {

    R encode(byte[] bytes);

    default R encode(String value) {
        return encode(value.getBytes());
    }

}
