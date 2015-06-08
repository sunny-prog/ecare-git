package service;

import java.io.Serializable;
import java.util.List;
/**
 * Created by Tatiana on 07.06.2015.
 */
public interface BaseService<T> {

    void add(final T entity);

    T update(final T entity);

    void delete(final Serializable id);

    T get(final Serializable id);

    List<T> getAll();

}
