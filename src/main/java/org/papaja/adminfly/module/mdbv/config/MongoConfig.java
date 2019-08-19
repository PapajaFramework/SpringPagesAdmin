package org.papaja.adminfly.module.mdbv.config;

import com.mongodb.MongoClient;
import org.papaja.adminfly.module.mdbv.common.converter.ZonedDateTimeReadConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.valueOf;

@SuppressWarnings({"unused"})
@Configuration
@EnableMongoRepositories(basePackages = "org.papaja.adminfly.module.mdbv.mongodb.repository")
@PropertySource(value = {
    "classpath:properties/module/mdbv/database.properties",
    "classpath:properties/module/mdbv/database.private.properties"
}, ignoreResourceNotFound = true)
public class MongoConfig extends AbstractMongoConfiguration {

    protected Environment environment;

    @Autowired
    public MongoConfig(Environment environment) {
        this.environment = environment;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(
            environment.getProperty("mdbv.connection.host"),
            valueOf(environment.getProperty("mdbv.connection.port"))
        );
    }

    @Override
    protected String getDatabaseName() {
        return environment.getProperty("mdbv.connection.name");
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singletonList("org.papaja.adminfly.module.mdbv.mongodb");
    }

    @Override
    public MongoCustomConversions customConversions() {
        List<Converter> converters = new ArrayList<>();

        converters.add(new ZonedDateTimeReadConverter());

        return new MongoCustomConversions(converters);
    }

}
