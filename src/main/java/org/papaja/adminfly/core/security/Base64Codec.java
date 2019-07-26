package org.papaja.adminfly.core.security;

import org.apache.commons.codec.binary.Base64;

public class Base64Codec implements Encoder<String>, Decoder<byte[]> {

    @Override
    public byte[] decode(byte[] bytes) {
        return Base64.decodeBase64(bytes);
    }

    @Override
    public String encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

}
