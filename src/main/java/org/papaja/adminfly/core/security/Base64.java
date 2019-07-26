package org.papaja.adminfly.core.security;

public class Base64 implements Encoder<String>, Decoder<String> {

    private org.apache.commons.codec.binary.Base64 base64;

    public Base64() {
        base64 = new org.apache.commons.codec.binary.Base64();
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
