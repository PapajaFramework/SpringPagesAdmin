package org.papaja.adminify.config;

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
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.papaja.adminify.controller")
@PropertySource("classpath:application.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Bean
    public JtwigViewResolver resolver(ContentNegotiationManager manager) {
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
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(getResponseBodyConverter());
    }

    @Bean
    public HttpMessageConverter<String> getResponseBodyConverter() {
        StringHttpMessageConverter converter  = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        List<MediaType>            mediaTypes = new ArrayList<>();

        mediaTypes.add(new MediaType("text", "html", UTF8));
        mediaTypes.add(new MediaType("text", "plain", UTF8));

        converter.setSupportedMediaTypes(mediaTypes);

        return converter;
    }

    @Bean
    public MessageSource getMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();

        source.setBasename("messages");
        source.setDefaultEncoding("UTF-8");

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