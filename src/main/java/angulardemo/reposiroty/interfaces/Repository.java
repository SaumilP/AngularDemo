package angulardemo.reposiroty.interfaces;

import java.util.List;

/**
 * Created by saumil on 2014/04/23.
 */
public interface Repository<T> {
    List<T> getAll();

    T getById(int id);
}
