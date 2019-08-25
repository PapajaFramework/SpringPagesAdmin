package org.papaja.adminfly.common.coder;

import static org.apache.commons.codec.binary.Base64.*;

public class Base64 implements Encoder<String>, Decoder<byte[]> {

    @Override
    public byte[] decode(byte[] bytes) {
        return decodeBase64(bytes);
    }

    @Override
    public String encode(byte[] bytes) {
        return encodeBase64String(bytes);
    }

}
