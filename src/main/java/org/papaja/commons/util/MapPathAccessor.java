package org.papaja.commons.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.papaja.commons.function.Extractor;

import java.util.Map;

@SuppressWarnings({"unchecked"})
public class MapPathAccessor implements Extractor<Map<String, Object>, String, Object> {

    public Object get(Map<String, Object> map, String key) {
        try {
            return PropertyUtils.getProperty(map, key);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
