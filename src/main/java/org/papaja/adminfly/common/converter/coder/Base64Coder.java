package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;

import static org.apache.commons.codec.binary.Base64.*;

public class Base64Coder implements Coder<byte[], String> {

    @Override
    public byte[] decode(String source) {
        return decode(source.getBytes());
    }

    @Override
    public String encode(byte[] bytes) {
        return encodeBase64String(bytes);
    }

    public byte[] decode(byte[] bytes) {
        return decodeBase64(bytes);
    }

    public String encode(String source) {
        return encode(source.getBytes());
    }

}
