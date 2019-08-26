package org.papaja.adminfly.module.mdbv.common.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeConverter implements Converter<Date, String> {

    @Override
    public String convert(Date source) {
        return DateTimeFormatter.ISO_DATE_TIME.format(source.toInstant());
    }

}
