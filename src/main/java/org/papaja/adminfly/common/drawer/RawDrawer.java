package org.papaja.adminfly.common.drawer;

import org.papaja.adminfly.common.util.Drawer;

import java.util.Objects;

public class RawDrawer implements Drawer<Object, String> {

    @Override
    public String apply(Object object) {
        return Objects.toString(object);
    }

}
