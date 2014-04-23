package angulardemo.service.interfaces;

import angulardemo.domain.User;

import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
public interface UserService {

    List<User> getAllUsers();

    User getById(int id);

    User createNewUser(User user);

    User update(User user);

    void remove(int id);

    int getNumberOfUsers();
}
