package org.papaja.adminfly.common.util.drawer;

import org.papaja.adminfly.common.util.Drawer;

import static java.lang.String.format;

public class RawDrawer implements Drawer<Object, String> {

    @Override
    public String apply(Object object) {
        return object.toString();
    }

}
