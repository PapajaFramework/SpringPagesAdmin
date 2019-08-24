package org.papaja.adminfly.module.mdbv.mongodb.record;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class MapRecord extends HashMap<String, Object> {

    private static final String OBJECT_ID = "_id";
    private static final String TIME_ID   = "time";

    public String getId() {
        Object value = get(OBJECT_ID);

        if (value instanceof ObjectId) {
            value = ((ObjectId)value).toHexString();
        }

        return (String) value;
    }

    public Optional<Object> getTime() {
        return ofNullable(get(TIME_ID));
    }

}
