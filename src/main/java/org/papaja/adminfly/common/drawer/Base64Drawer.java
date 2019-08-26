package org.papaja.adminfly.common.drawer;

import org.papaja.adminfly.common.coder.Base64;
import org.papaja.adminfly.common.util.Drawer;

public class Base64Drawer implements Drawer<String, String> {

    private static final Base64 BASE_64 = new Base64();

    @Override
    public String apply(String input) {
        return new String(BASE_64.decode(input));
    }

}
