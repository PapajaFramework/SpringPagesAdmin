package org.papaja.adminify.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SuppressWarnings({"unused"})
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        super.onStartup(context);

        Properties          properties = getApplicationProperties();
        SessionCookieConfig config     = context.getSessionCookieConfig();

        config.setName(properties.getProperty("app.security.session.cookieName"));
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{OrmConfig.class, SecurityConfig.class,};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);

        return new Filter[]{filter};
    }

    // @todo unfortunately hardcoded
    private Properties getApplicationProperties() {
        ClassLoader loader     = ApplicationInitializer.class.getClassLoader();
        Properties  properties = new Properties();
        InputStream stream     = new BufferedInputStream(loader.getResourceAsStream("application.properties"));

        try {
            properties.load(stream);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return properties;
    }

}
