package org.papaja.adminfly.common.converter.coder;

import org.papaja.adminfly.common.converter.Coder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaDateCoder implements Coder<Date, String> {

    private static final DateTimeFormatter FORMATTER;

    static {
        FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
    }

    @Override
    public Date decode(String source) {
        return Date.from(LocalDateTime.from(FORMATTER.parse(source)).toInstant(ZoneOffset.UTC));
    }

    @Override
    public String encode(Date date) {
        return FORMATTER.format(date.toInstant());
    }

}
