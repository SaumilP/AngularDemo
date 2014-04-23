package angulardemo.reposiroty.interfaces;

import angulardemo.domain.User;

/**
 * Created by saumil on 2014/04/23.
 */
public interface DummyRepository extends Repository<User> {
    User getDefaultUser();
}
