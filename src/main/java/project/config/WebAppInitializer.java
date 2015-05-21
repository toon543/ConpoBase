package project.config;

import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.io.IOException;

/**
 * Created by P-OniSawa on 11/5/2558.
 */
public class WebAppInitializer implements WebApplicationInitializer {




    String basicConfig = "classpath:/setup.properties";
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ConfigurableEnvironment env = ctx.getEnvironment();
        try {
            env.getPropertySources().addFirst(new ResourcePropertySource(basicConfig));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, env.getProperty("activeProfile"));
        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        dynamic.addMapping("/");
        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
                .addMappingForUrlPatterns(null, false, "/*");
        dynamic.setLoadOnStartup(1);
    }
}
