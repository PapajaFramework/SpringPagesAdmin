package org.papaja.adminfly.common.formatter;

import org.papaja.adminfly.common.data.coder.Base64;
import org.papaja.adminfly.common.util.Formatter;

public class Base64Formatter implements Formatter<String, String> {

    private static final Base64 BASE_64 = new Base64();

    @Override
    public String format(String input) {
        return new String(BASE_64.decode(input.getBytes()));
    }

}
