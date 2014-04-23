package angulardemo.repository.implementation;

import angulardemo.domain.EmptyUser;
import angulardemo.domain.User;
import angulardemo.reposiroty.interfaces.UserRepository;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import com.google.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
@Singleton
public class UserRepositoryImpl extends GenericMockRepository<User> implements UserRepository {

    private List<User> users = new ArrayList<>();

    public UserRepositoryImpl(){
       this.users = this.createUsers();
    }

    public User getById(int id){
        for(User usr : this.users ){
            if (usr.getId() == id ){
                return usr;
            }
        }
        return new EmptyUser();
    }

    public List<User> getAll(){
        return this.users;
    }

    private List<User> createUsers(){
        int noOfUsers = 10;
        for(int i = 0; i< noOfUsers; i++){
            User usr = new User();
            usr.setId(i+1);
            usr.setFirstName("John " + i);
            usr.setLastName("Doe");
            this.users.add(usr);
        }
        return users;
    }

    @Override
    public User update(User user ){
        User byId = getById(user.getId());
        if ( byId != null ){
            byId.setFirstName(user.getFirstName());
            byId.setLastName(user.getLastName());
            return byId;
        }
        return user;
    }

    @Override
    public void remove(int id){
        User byId = getById(id);
        if ( byId != null ){
            this.users.remove(byId);
        }
    }

    @Override
    public User create(User user ){
        user.setId( getCurrentMax() + 1 );
        this.users.add(user);
        return user;
    }

    private int getCurrentMax(){
        Ordering<User> ordering = new Ordering<User>() {
            @Override
            public int compare(User left, User right) {
                return Ints.compare(left.getId(), right.getId());
            }
        };
        return ordering.max(this.users).getId();
    }

    @Override
    public int getNumberOfUsers(){
        return this.users.size();
    }


}
