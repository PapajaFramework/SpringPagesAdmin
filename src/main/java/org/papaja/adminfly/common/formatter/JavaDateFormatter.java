package org.papaja.adminfly.common.formatter;

import org.papaja.adminfly.common.util.Formatter;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaDateFormatter implements Formatter<Date, String> {

    @Override
    public String format(Date javaDate) {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneId.systemDefault());

        return new StringFormatter().format(
                javaDate.toInstant()
//                FORMATTER.format(javaDate.toInstant())
        );
    }

}
