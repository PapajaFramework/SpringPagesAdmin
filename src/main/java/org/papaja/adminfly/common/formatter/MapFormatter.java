package org.papaja.adminfly.common.formatter;

import org.papaja.adminfly.common.util.Formatter;

import java.util.Map;

public class MapFormatter implements Formatter<Map<?, ?>, String> {

    private static final RawFormatter    RAW_DRAWER;
    private static final StringFormatter STRING_DRAWER;

    static {
        STRING_DRAWER = new StringFormatter();
        RAW_DRAWER = new RawFormatter();
    }

    @Override
    public String format(Map<?, ?> map) {
        return drawMap(map);
    }

    private String drawMap(Map<?, ?> map) {
        final StringBuilder builder = new StringBuilder();

        map.forEach((key, value) -> {
            builder.append("\n");
            builder.append(RAW_DRAWER.format(key));
            builder.append(": ");
            builder.append(STRING_DRAWER.format(value));
        });

        return builder.toString();
    }
}
