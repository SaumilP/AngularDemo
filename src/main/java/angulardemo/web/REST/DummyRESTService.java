package angulardemo.web.REST;

import angulardemo.domain.User;
import angulardemo.service.interfaces.DummyService;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by saumil on 2014/04/23.
 */

@Path("/dummy")
public class DummyRESTService {
    private final DummyService dummyService;

    @Inject
    public DummyRESTService( DummyService dummyService ){
        this.dummyService = dummyService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User getDefaultDummyInJSON(){
        return dummyService.getDefaultUser();
    }
}
