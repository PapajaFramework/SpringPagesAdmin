package org.papaja.adminfly.module.mdbv.common.manager;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.HashMap;
import java.util.Map;

public class MongoDatabaseManager {

    private Map<String, MongoTemplate> templates;
    private MongoClient                client;

    public MongoDatabaseManager(MongoClient client) {
        this.client = client;
        this.templates = new HashMap<>();
    }

    public MongoTemplate getMongoTemplateForDatabase(String database) {
        boolean isNew = !templates.containsKey(database);

        if (isNew) {
            templates.put(database, new MongoTemplate(client, database));
        }

        return templates.get(database);
    }


}
