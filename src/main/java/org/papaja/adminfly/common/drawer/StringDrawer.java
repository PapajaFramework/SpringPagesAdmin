package org.papaja.adminfly.common.drawer;

import static java.lang.String.format;

public class StringDrawer extends RawDrawer {

    @Override
    public String apply(Object object) {
        return format("'%s'", super.apply(object));
    }

}
