package org.papaja.adminfly.module.mdbv.shared.formatter;

import org.papaja.adminfly.common.data.Format;
import org.papaja.adminfly.common.formatter.*;
import org.papaja.adminfly.common.util.Formatter;
import org.papaja.adminfly.common.util.function.Function;

import java.util.EnumMap;
import java.util.Map;

import static org.papaja.adminfly.common.data.Format.*;

public enum  FormatterFactory implements Function<Format, Formatter> {

    INSTANCE;

    private static final Map<Format, Formatter> FORMATTERS = new EnumMap<>(Format.class);

    static {
        FORMATTERS.put(BASE64, new Base64Formatter());
//        FORMATTERS.put(RAW, new StringFormatter());
//        FORMATTERS.put(LIST, new ListFormatter());
//        FORMATTERS.put(MAP, new MapFormatter());
        FORMATTERS.put(JAVA_DATE, new JavaDateFormatter());
    }

    @Override
    public Formatter apply(Format format) {
        return FORMATTERS.get(format);
    }

    public Formatter get(Format format) {
        return apply(format);
    }

}
