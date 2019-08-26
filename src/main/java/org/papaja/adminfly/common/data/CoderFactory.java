package org.papaja.adminfly.common.data;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.common.data.Format.*;

public enum CoderFactory {

    INSTANCE;

    private static final Map<Format, Coder> CODERS = new EnumMap<>(Format.class);

    static {
        CODERS.put(BASE64, BASE64.getCoder());
        CODERS.put(JAVA_DATE, JAVA_DATE.getCoder());
    }

}
