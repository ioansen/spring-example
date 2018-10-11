package uti.ro.java.tutorials;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Configuration
@EnableWebMvc
@ComponentScan("uti.ro.java.tutorials")
public class HelloApp implements WebApplicationInitializer {

    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appCtx =
                new AnnotationConfigWebApplicationContext();

        appCtx.register(HelloApp.class);

        servletContext.addListener(new ContextLoaderListener(appCtx));
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(appCtx));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
