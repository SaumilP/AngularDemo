package angulardemo.tests.integration.web;

import angulardemo.tests.integration.web.infrastructure.ClientProvider;
import angulardemo.tests.integration.web.infrastructure.ServerProvider;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
/**
 * Created by saumil on 2014/04/23.
 */
public class UserRESTServiceTest {
    private final ServerProvider serverProvider;
    private final ClientProvider clientProvider;
    private WebResource service;

    public UserRESTServiceTest(){
        this.serverProvider = new ServerProvider();
        this.clientProvider = new ClientProvider(serverProvider);
    }

    @Before
    public void startServer() throws IOException {
        serverProvider.createServer();
        service = clientProvider.getWebResource();
    }

    @After
    public void stopServer() throws IOException{
        serverProvider.stop();
    }

    @Test
    public void testGetAllUsersShouldReturnSuccessStatus() throws IOException {
        ClientResponse resp = service.path("web").path("users").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        System.out.println("Received Response : " + resp);

        assertEquals(200, resp.getStatus() );
    }

    @Test
    public void testGetAllUserShouldReturnJSArray() throws IOException {
        ClientResponse resp = service.path("web").path("users").accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        System.out.println("Received Response : " + resp);

        String actualString = resp.getEntity(String.class);

        assertTrue("Result must be a JavaScript array: But it starts with '{'!", !actualString.startsWith("{"));
        assertTrue("Result must be a JavaScript array: But it does not start with '['!", actualString.startsWith("["));
    }

}
