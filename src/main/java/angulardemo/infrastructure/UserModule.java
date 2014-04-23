package angulardemo.infrastructure;

import angulardemo.reposiroty.interfaces.DummyRepository;
import angulardemo.reposiroty.interfaces.UserRepository;
import angulardemo.repository.implementation.DummyRepositoryImpl;
import angulardemo.repository.implementation.UserRepositoryImpl;
import angulardemo.service.implementation.DummyServiceImpl;
import angulardemo.service.implementation.UserServiceImpl;
import angulardemo.service.interfaces.DummyService;
import angulardemo.service.interfaces.UserService;
import com.google.inject.AbstractModule;

/**
 * Created by saumil on 2014/04/23.
 */
public class UserModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(DummyRepository.class).to(DummyRepositoryImpl.class);
        bind(DummyService.class).to(DummyServiceImpl.class);

        bind(UserRepository.class).to(UserRepositoryImpl.class);
        bind(UserService.class).to(UserServiceImpl.class);
    }
}
