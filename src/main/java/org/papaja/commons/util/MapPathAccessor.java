package org.papaja.commons.util;

import org.apache.commons.beanutils.PropertyUtils;

import org.papaja.commons.function.Provider;

import java.util.Map;

@SuppressWarnings({"unchecked"})
public class MapPathAccessor {

    public Object get(Map<String, Object> map, String key) {
        try {
            return PropertyUtils.getProperty(map, key);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

}
