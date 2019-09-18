package org.papaja.commons.converter.coder;

import org.papaja.commons.converter.Coder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaDateCoder implements Coder<Date, String> {

    private static final DateTimeFormatter FORMATTER;
    private static final ZoneOffset        OFFSET;

    static {
        OFFSET = ZoneOffset.UTC;
        FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(OFFSET);
    }

    @Override
    public Date decode(String source) {
        return Date.from(LocalDateTime.from(FORMATTER.parse(source)).toInstant(OFFSET));
    }

    @Override
    public String encode(Date date) {
        return FORMATTER.format(date.toInstant());
    }

}
