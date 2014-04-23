package angulardemo.repository.implementation;

import angulardemo.domain.User;
import angulardemo.reposiroty.interfaces.DummyRepository;

/**
 * Created by saumil on 2014/04/23.
 */
public class DummyRepositoryImpl extends GenericMockRepository<User> implements DummyRepository {

    @Override
    public User getDefaultUser(){
        User usr = new User();
        usr.setFirstName("John");
        usr.setLastName("Doe");
        return usr;
    }
}
