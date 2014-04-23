package angulardemo.repository.implementation;

import angulardemo.reposiroty.interfaces.Repository;

import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
public abstract class GenericMockRepository<T> implements Repository<T> {
    @Override
    public List<T> getAll(){
        return null;
    }

    @Override
    public T getById(int id){
        return (T)null;
    }
}
