package org.papaja.adminfly.common.drawer;

import org.papaja.adminfly.common.util.Drawer;

import java.util.Map;

public class MapDrawer implements Drawer<Map<?, ?>, String> {

    private static final RawDrawer  RAW_DRAWER;
    private static final StringDrawer STRING_DRAWER;

    static {
        STRING_DRAWER = new StringDrawer();
        RAW_DRAWER = new RawDrawer();
    }

    @Override
    public String apply(Map<?, ?> map) {
        return drawMap(map);
    }

    private String drawMap(Map<?, ?> map) {
        final StringBuilder builder = new StringBuilder();

        map.forEach((key, value) -> {
            builder.append("\n");
            builder.append(RAW_DRAWER.draw(key));
            builder.append(": ");
            builder.append(STRING_DRAWER.draw(value));
        });

        return builder.toString();
    }
}
