package angulardemo.infrastructure;

import angulardemo.web.REST.ResponseCorsFilter;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 * Created by saumil on 2014/04/23.
 */
public class AngularAppSetup extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule(){
            @Override
        protected void configureServlets(){
                super.configureServlets();

                ResourceConfig resourceConfig = new PackagesResourceConfig("angulardemo/web");
                for(Class<?> resource : resourceConfig.getClasses() ){
                    bind(resource);
                }

                bind(JacksonJsonProvider.class).in(Scopes.SINGLETON);

                serve("/web/*").with(GuiceContainer.class);

                filter("/web/*").through(ResponseCorsFilter.class);
            }
        }, new UserModule());
    }
}
