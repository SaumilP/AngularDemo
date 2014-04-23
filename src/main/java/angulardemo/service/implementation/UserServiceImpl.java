package angulardemo.service.implementation;

import angulardemo.domain.User;
import angulardemo.reposiroty.interfaces.UserRepository;
import angulardemo.service.interfaces.UserService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
@Singleton
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Inject
    public  UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User createNewUser(User user) {
        return userRepository.create(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public void remove(int id) {
        userRepository.remove(id);
    }

    @Override
    public int getNumberOfUsers() {
        return userRepository.getNumberOfUsers();
    }
}
