package org.papaja.adminfly.core.security;

import org.apache.commons.codec.binary.Base64;

public class Base64Codec implements Encoder<String>, Decoder<String> {

    private Base64 base64;

    public Base64Codec() {
        this.base64 = new Base64();
    }

    @Override
    public String decode(byte[] bytes) {
        return new String(base64.decode(bytes));
    }

    @Override
    public String encode(byte[] bytes) {
        return new String(base64.encode(bytes));
    }

}
