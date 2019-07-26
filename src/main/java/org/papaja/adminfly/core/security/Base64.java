package org.papaja.adminfly.core.security;

import java.nio.charset.StandardCharsets;

import static java.util.Base64.*;

public class Base64 implements Encoder<String>, Decoder<String> {

    @Override
    public String decode(byte[] bytes) {
        return new String(getDecoder().decode(bytes));
    }

    @Override
    public String encode(byte[] bytes) {
        return new String(getEncoder().encode(bytes));
    }

}
