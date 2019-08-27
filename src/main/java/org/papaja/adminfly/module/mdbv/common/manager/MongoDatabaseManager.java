package org.papaja.adminfly.module.mdbv.common.manager;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.Map;

public class MongoDatabaseManager {

    private ThreadLocal<Map<String, MongoTemplate>> local;
    private MongoClient                             client;

    public MongoDatabaseManager(MongoClient client) {
        this.client = client;
        this.local  = new ThreadLocal<>();
        this.local.set(new HashMap<>());
    }

    public MongoTemplate getMongoTemplateForDatabase(String database) {
        boolean isNew = !local.get().containsKey(database);

        if (isNew) {
            local.get().put(database, new MongoTemplate(client, database));
        }

        return local.get().get(database);
    }


}
