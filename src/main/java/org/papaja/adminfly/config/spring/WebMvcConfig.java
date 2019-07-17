package org.papaja.adminfly.config.spring;

import org.hibernate.validator.HibernateValidator;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.render.RenderExtension;
import org.jtwig.spring.JtwigView;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.translate.spring.SpringTranslateExtension;
import org.jtwig.translate.spring.SpringTranslateExtensionConfiguration;
import org.jtwig.web.servlet.JtwigRenderer;
import org.papaja.adminfly.core.jtwig.extension.asset.resolver.ResourceUrlBasedAssetResolver;
import org.papaja.adminfly.core.spring.web.servlet.resource.ContentHashVersionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.resource.*;

import java.nio.charset.Charset;
import java.util.Locale;

@SuppressWarnings({"unused"})
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan("org.papaja.adminfly.controller")
@PropertySource("classpath:application.properties")
public class WebMvcConfig implements WebMvcConfigurer {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private Environment environment;

    @Autowired
    public WebMvcConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public JtwigViewResolver viewResolver() {
        EnvironmentConfigurationBuilder builder  = EnvironmentConfigurationBuilder.configuration();
        JtwigViewResolver               resolver = new JtwigViewResolver();
        SpringTranslateExtensionConfiguration translate = SpringTranslateExtensionConfiguration.builder(messageSource()).withLocaleResolver(localeResolver()).build();

        builder.extensions()
            .add(new SpringAssetExtension())
            .add(new RenderExtension())
            .add(new SpringTranslateExtension(translate));

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

    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource  source = new ReloadableResourceBundleMessageSource();

        source.addBasenames(
                "classpath:locale/messages/messages",
                "classpath:locale/system/text",
                "classpath:locale/system/title",
                "classpath:locale/system/label",
                "classpath:locale/system/flash"
        );
        source.setFallbackToSystemLocale(true);
        source.setDefaultEncoding("UTF-8");

        return source;
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();

        resolver.setDefaultLocale(Locale.forLanguageTag(environment.getProperty("app.locale.defaultLocale").replace('_', '-')));
        resolver.setCookieName(environment.getProperty("app.locale.cookieName"));

        return resolver;
    }

    @Bean
    public AssetResolver assetResolver() {
        ResourceUrlBasedAssetResolver resolver = new ResourceUrlBasedAssetResolver();

        resolver.setPrefix("/static");

        return resolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("static/**")
                .addResourceLocations("classpath:/assets/")
                .setCachePeriod(2629743)
                .resourceChain(true)
                .addResolver(new EncodedResourceResolver())
                .addResolver(new VersionResourceResolver()
                        .addVersionStrategy(new ContentHashVersionStrategy(), "/**/*.css", "/**/*.js"));
    }

    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Bean
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();

        validator.setValidationMessageSource(messageSource());
        validator.setProviderClass(HibernateValidator.class);

        return validator;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();

        interceptor.setParamName(environment.getProperty("app.locale.queryParameterName"));

        return interceptor;

    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(Integer.valueOf(environment.getProperty("app.file.upload.maxSize")));

        return multipartResolver;
    }


}