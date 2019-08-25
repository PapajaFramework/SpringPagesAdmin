package org.papaja.adminfly.common.util.drawer;

import org.papaja.adminfly.common.util.Drawer;

import java.util.List;
import java.util.Map;

public class MapDrawer implements Drawer<Map<?, ?>, String> {

    private static final ListDrawer LIST_DRAWER;
    private static final RawDrawer  RAW_DRAWER;
    private static final StringDrawer STRING_DRAWER;

    static {
        STRING_DRAWER = new StringDrawer();
        RAW_DRAWER = new RawDrawer();
        LIST_DRAWER = new ListDrawer();
    }

    @Override
    public String apply(Map<?, ?> map) {
        return drawMap(map, 0);
    }

    private String drawMap(Map<?, ?> map, int indent) {
        final StringBuilder builder = new StringBuilder();

        map.forEach((key, value) -> {
            builder.append("\n");
            builder.append(indent(indent) + RAW_DRAWER.apply(key));
            builder.append(": ");
            builder.append(drawValue(value, indent));
        });

        return builder.toString();
    }

    private String drawValue(Object value, int indent) {
        if (value instanceof List) {
            return LIST_DRAWER.apply((List<?>) value);
        } else if (value instanceof Map) {
            return drawMap((Map<?, ?>) value, indent + 1);
        } else {
            return STRING_DRAWER.apply(value);
        }
    }

    private String indent(int count) {
        return new String(new char[count]).replace("\0", "\t");
    }

}
