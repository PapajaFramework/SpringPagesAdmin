package org.papaja.adminify.config;

import org.jtwig.environment.EnvironmentConfiguration;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.spring.asset.resolver.BaseAssetResolver;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.papaja.adminify.controller")
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public JtwigViewResolver resolver() {
        SpringAssetExtension            extension     = new SpringAssetExtension();
        EnvironmentConfigurationBuilder builder       = EnvironmentConfigurationBuilder.configuration();
        EnvironmentConfiguration        configuration = builder.extensions().add(extension).and().build();
        JtwigViewResolver               resolver      = new JtwigViewResolver();

        resolver.setRenderer(new JtwigRenderer(configuration));
        resolver.setViewClass(JtwigView.class);
        resolver.setPrefix("web:/WEB-INF/views/");
        resolver.setSuffix(".twig");

        return resolver;
    }

    @Bean
    public AssetResolver getAssetResolver() {
        BaseAssetResolver resolver = new BaseAssetResolver();

        resolver.setPrefix("/assets");

        return resolver;
    }

    @Bean
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();

        source.setBasename("messages");

        return source;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("assets/**")
                .addResourceLocations("classpath:/assets/")
                .setCachePeriod(31556926);
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(getMessageSource());

        return validator;
    }


}