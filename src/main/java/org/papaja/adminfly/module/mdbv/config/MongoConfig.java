package org.papaja.adminfly.module.mdbv.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SuppressWarnings({"unused"})
@Configuration
@EnableMongoRepositories(basePackages = "org.papaja.adminfly.module.mdbv.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }

}
