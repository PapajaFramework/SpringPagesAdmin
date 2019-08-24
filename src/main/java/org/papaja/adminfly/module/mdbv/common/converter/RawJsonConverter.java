package org.papaja.adminfly.module.mdbv.common.converter;

import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

import static java.util.Objects.isNull;

public class RawJsonConverter implements Converter<DBObject, String> {

    @Override
    public String convert(DBObject source) {
        return isNull(source) ? "{}" : source.toString();
    }
}
