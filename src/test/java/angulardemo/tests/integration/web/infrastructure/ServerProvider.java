package angulardemo.tests.integration.web.infrastructure;

import angulardemo.reposiroty.interfaces.DummyRepository;
import angulardemo.reposiroty.interfaces.UserRepository;
import angulardemo.repository.implementation.DummyRepositoryImpl;
import angulardemo.repository.implementation.UserRepositoryImpl;
import angulardemo.service.implementation.DummyServiceImpl;
import angulardemo.service.implementation.UserServiceImpl;
import angulardemo.service.interfaces.DummyService;
import angulardemo.service.interfaces.UserService;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Created by saumil on 2014/04/23.
 */
public class ServerProvider {
    private final URI URI_BASE = getBaseURI();
    private HttpServer server;

    protected URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9999).build();
    }

    public void createServer() throws IOException {
        System.out.println("Starting up Grizzly...");
        Injector injector = Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets(){
                bind(UserService.class).to(UserServiceImpl.class);
                bind(UserRepository.class).to(UserRepositoryImpl.class);
                bind(DummyService.class).to(DummyServiceImpl.class);
                bind(DummyRepository.class).to(DummyRepositoryImpl.class);

                bind(JacksonJaxbJsonProvider.class).in(Scopes.SINGLETON);
            }
        });

        ResourceConfig rc = new PackagesResourceConfig("angulardemo.web");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
        server = GrizzlyServerFactory.createHttpServer(URI_BASE + "web/", rc ,ioc);

        System.out.println(String.format("Jersey app started with WADL available at %srest/application.wadl\nTry out %sangulardemo\nHit enter to stop it...", URI_BASE, URI_BASE ));
    }

    public void stop(){
        server.stop();
    }
}
