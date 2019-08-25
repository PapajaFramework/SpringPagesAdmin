package org.papaja.adminfly.common.util.drawer;

import org.papaja.adminfly.common.util.Drawer;

import static java.lang.String.format;

public class StringDrawer extends RawDrawer {

    @Override
    public String apply(Object object) {
        return format("\"%s\"", super.apply(object));
    }

}
