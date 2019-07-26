package org.papaja.adminfly.core.security;

import org.apache.commons.codec.binary.Base64;

public class Base64Codec implements Encoder<String>, Decoder<String> {

    @Override
    public String decode(byte[] bytes) {
        return new String(Base64.decodeBase64(bytes));
    }

    @Override
    public String encode(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

}
