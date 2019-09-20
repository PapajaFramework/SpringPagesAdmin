package org.papaja.adminfly.module.kv.config;

import org.papaja.adminfly.shared.data.AvailableModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = {
        "classpath:properties/module/kv/module.properties",
}, ignoreResourceNotFound = true)
public class KVStorageConfig {

    protected Environment environment;

    public @Autowired
    KVStorageConfig(Environment environment) {
        this.environment = environment;

        AvailableModules.addModule(
                environment.getProperty("module.kv.name"),
                environment.getProperty("module.kv.path")
        );
    }

}
