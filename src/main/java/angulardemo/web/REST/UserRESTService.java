package angulardemo.web.REST;

import angulardemo.domain.User;
import angulardemo.service.interfaces.UserService;
import com.google.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
@Path("/users")
public class UserRESTService  {
    private final UserService service;

    @Inject
    public UserRESTService(UserService service){
        this.service = service;
    }

    @GET @Path("numberOfUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public int getNumberOfUsers(){
        return service.getNumberOfUsers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getAllUsersInJSON(){
        return service.getAllUsers();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserById(@PathParam("id") int id ){
        return service.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User create(User user){
        return service.createNewUser(user);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User update(User user){
        return service.update(user);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void remove(@PathParam("id") int id){
        service.remove(id);
    }
}
