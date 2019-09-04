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
        map.forEach((key, value) -> {
            key = nonNull(prefix) ? format("%s.%s", prefix, key) : key;
            if (Map.class.isAssignableFrom(value.getClass())) {
                collectPaths((Map<String, ?>) value, paths, key);
            } else {
                paths.add(key);
            }
        });
    }

}
