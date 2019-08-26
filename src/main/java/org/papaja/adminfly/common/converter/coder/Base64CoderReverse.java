package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;

public class Base64CoderReverse implements Coder<String, String> {

    @Override
    public String encode(String source) {
        return new String(new Base64Coder().decode(source));
    }

    @Override
    public String decode(String source) {
        return new Base64Coder().encode(source);
    }

}
