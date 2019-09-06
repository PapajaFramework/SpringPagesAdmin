package org.papaja.adminfly.common.util;

import java.util.*;

import static java.lang.String.format;
import static java.util.Objects.nonNull;

public class MapUtils {

    public static List<String> getPaths(Map<String, ?> map) {
        List<String> paths = new ArrayList<>();

        collectPaths(map, paths, null);

        return paths;
    }

    public static void collectPaths(Map<String, ?> map, List<String> paths, String prefix) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key   = entry.getKey();
            Object value = entry.getValue();
            String path  = nonNull(prefix) ? format("%s.%s", prefix, key) : key;

            if (nonNull(value) && Map.class.isAssignableFrom(value.getClass())) {
                collectPaths((Map<String, ?>) value, paths, path);
                continue;
            }

            paths.add(path);
        }
    }

}
