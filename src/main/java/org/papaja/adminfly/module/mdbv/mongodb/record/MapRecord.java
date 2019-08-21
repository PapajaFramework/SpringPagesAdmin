package org.papaja.adminfly.module.mdbv.mongodb.record;

import org.bson.types.ObjectId;

import java.util.HashMap;

public class MapRecord extends HashMap<String, Object> {

    private static final String OBJECT_ID = "_id";

    public String getId() {
        return ((ObjectId) get(OBJECT_ID)).toHexString();
    }

}
