package org.papaja.adminifly.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@SuppressWarnings({"unused"})
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@ComponentScan({"org.papaja.adminifly"})
public class OrmConfig {

    private Environment environment;

    @Autowired
    public OrmConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();

        manager.setSessionFactory(getSessionFactory().getObject());

        return manager;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();

        factory.setPackagesToScan("org.papaja.adminifly.entity");
        factory.setDataSource(getDataSource());
        factory.setHibernateProperties(getHibernateProperties());

        return factory;
    }

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();

        // Connection
        source.setDriverClassName(environment.getProperty("connection.driver"));
        source.setUrl(environment.getProperty("connection.url"));
        source.setUsername(environment.getProperty("connection.username"));
        source.setPassword(environment.getProperty("connection.password"));

        return source;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();

        // Hibernate Settings
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.showSql"));
        properties.put("hibernate.connection.provider_class", environment.getProperty("hibernate.connection.provider"));

        // Hikari Settings
        properties.put("hibernate.hikari.connectionTimeout", environment.getProperty("hikari.connectionTimeout"));
        properties.put("hibernate.hikari.minimumIdle", environment.getProperty("hikari.minimumIdle"));
        properties.put("hibernate.hikari.maximumPoolSize", environment.getProperty("hikari.maximumPoolSize"));
        properties.put("hibernate.hikari.idleTimeout", environment.getProperty("hikari.idleTimeout"));

        // Data Source Settings
        properties.put("hibernate.hikari.dataSourceClassName", environment.getProperty("connection.dataSource"));
        properties.put("hibernate.hikari.dataSource.url", environment.getProperty("connection.url"));
        properties.put("hibernate.hikari.dataSource.user", environment.getProperty("connection.username"));
        properties.put("hibernate.hikari.dataSource.password", environment.getProperty("connection.password"));

        return properties;
    }

}
