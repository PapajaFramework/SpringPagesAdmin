package org.papaja.adminfly.module.mdbv.mongodb.record;

import org.bson.types.ObjectId;

import java.util.HashMap;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class MapRecord extends HashMap<String, Object> {

    private static final String OBJECT_ID = "_id";
    private static final String TIME_ID   = "time";

    public String getId() {
        return ((ObjectId) get(OBJECT_ID)).toHexString();
    }

    public Optional<Object> getTime() {
        return ofNullable(get(TIME_ID));
    }

}
