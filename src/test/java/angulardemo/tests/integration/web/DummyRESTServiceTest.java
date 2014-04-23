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
/**
 * Created by saumil on 2014/04/23.
 */
public class DummyRESTServiceTest {
    private final ServerProvider serverProvider;
    private final ClientProvider clientProvider;

    public DummyRESTServiceTest(){
        this.serverProvider = new ServerProvider();
        this.clientProvider = new ClientProvider(serverProvider);
    }

    @Before
    public void startServer() throws IOException {
        serverProvider.createServer();
    }

    @After
    public void stopServer(){
        serverProvider.stop();
    }

    @Test
    public void testGetDefaultUser() throws IOException {
        WebResource service = clientProvider.getWebResource();
        ClientResponse response = service.path("web").path("dummy")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        System.out.println("Received Response : " + response);
        String responseMessage = response.getEntity(String.class);

        assertEquals(200, response.getStatus() );
        assertEquals("{\"id\":0,\"firstName\":\"John\",\"lastName\":\"Doe\"}", responseMessage);
    }

}
