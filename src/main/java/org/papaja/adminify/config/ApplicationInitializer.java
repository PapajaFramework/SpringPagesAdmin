package org.papaja.adminify.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import java.util.ResourceBundle;

@SuppressWarnings({"unused"})
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        super.onStartup(context);

        ResourceBundle      resource = ResourceBundle.getBundle("application.properties");
        SessionCookieConfig config   = context.getSessionCookieConfig();

        config.setName(resource.getString("app.session.sessionCookie"));
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                OrmConfig.class, SecurityConfig.class,
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
