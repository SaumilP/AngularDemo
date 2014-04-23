package angulardemo.service.implementation;

import angulardemo.domain.User;
import angulardemo.reposiroty.interfaces.DummyRepository;
import angulardemo.service.interfaces.DummyService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by saumil on 2014/04/23.
 */
@Singleton
public class DummyServiceImpl implements DummyService {

    private final DummyRepository dRepo;

    @Inject
    public DummyServiceImpl(DummyRepository dummyRepository){
        dRepo = dummyRepository;
    }

    @Override
    public User getDefaultUser() {
        Object defaultUser = dRepo.getDefaultUser();
        return dRepo.getDefaultUser();
    }
}
