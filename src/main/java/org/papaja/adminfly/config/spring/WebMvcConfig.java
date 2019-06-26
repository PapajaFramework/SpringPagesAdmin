package org.papaja.adminfly.config.spring;

import org.hibernate.validator.HibernateValidator;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.spring.asset.resolver.BaseAssetResolver;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.nio.charset.Charset;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.papaja.adminfly.controller")
@PropertySource("classpath:application.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Bean
    public JtwigViewResolver resolver() {
        SpringAssetExtension            extension = new SpringAssetExtension();
        EnvironmentConfigurationBuilder builder   = EnvironmentConfigurationBuilder.configuration();
        JtwigViewResolver               resolver  = new JtwigViewResolver();

        builder.extensions().add(extension);
        builder.render().withOutputCharset(UTF8);
        builder.resources().withDefaultInputCharset(UTF8);

        resolver.setRenderer(new JtwigRenderer(builder.build()));
        resolver.setViewClass(JtwigView.class);
        resolver.setPrefix("web:/WEB-INF/views/");
        resolver.setSuffix(".twig");
        resolver.setContentType("text/html");

        return resolver;
    }

    @Bean
    public AssetResolver getAssetResolver() {
        BaseAssetResolver resolver = new BaseAssetResolver();

        resolver.setPrefix("/assets");

        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("assets/**").addResourceLocations("classpath:/assets/").setCachePeriod(31556926);
    }

    @Bean
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(getMessageSource());
        validator.setProviderClass(HibernateValidator.class);

        return validator;
    }

    @Bean
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();

        source.setBasename("messages");
        source.setDefaultEncoding("UTF-8");

        return source;
    }

}