package angulardemo.reposiroty.interfaces;

import angulardemo.domain.User;

/**
 * Created by saumil on 2014/04/23.
 */
public interface UserRepository extends Repository<User> {
    User create(User user);
    User update(User user);

    void remove(int id);

    int getNumberOfUsers();
}
