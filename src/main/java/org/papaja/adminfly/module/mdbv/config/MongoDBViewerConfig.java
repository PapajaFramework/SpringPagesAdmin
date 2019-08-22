package org.papaja.adminfly.module.mdbv.config;

import org.papaja.adminfly.module.mdbv.common.holder.MdbvCollectionNameHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
    "classpath:properties/module/mdbv/module.properties"
}, ignoreResourceNotFound = true)
public class MongoDBViewerConfig {

    protected Environment environment;

    @Autowired
    public MongoDBViewerConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public MdbvCollectionNameHolder getCollectionDetector() {
        return new MdbvCollectionNameHolder(environment.getProperty("module.mdbv.currentCollection"));
    }

}
