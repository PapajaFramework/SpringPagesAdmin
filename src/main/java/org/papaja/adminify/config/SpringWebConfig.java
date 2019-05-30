package org.papaja.adminify.config;

import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.papaja.adminify.controller"})
public class SpringWebConfig implements WebMvcConfigurer {

    @Bean
    public JtwigViewResolver resolver() {
        JtwigViewResolver resolver = new JtwigViewResolver();

        resolver.setViewClass(JtwigView.class);
        resolver.setPrefix("web:/WEB-INF/views/");
        resolver.setSuffix(".twig.html");

        return resolver;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(messageSource());

        return validator;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();

        source.setBasename("messages");

        return source;
    }
}