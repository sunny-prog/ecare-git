package service;

import java.io.Serializable;
import java.util.List;

/**
 * Provides the base service interface for the Generic service to do CRUD operations.
 *
 * @param <T> could be any type (User, Option, etc), which has corresponding table in the DB.
 * @author Tatiana
 * @version 1.0
 */
public interface BaseService<T> {
    /**
     * Adds an entity.
     *
     * @param entity is the entity of type T that will be added the corresponding table
     */
    void add(final T entity);

    /**
     * Updates the entity of type T.
     *
     * @param entity the entity of type T stored in the corresponding table
     * @return the entity
     */
    T update(final T entity);

    /**
     * Deletes the entity of type T with the primary key.
     *
     * @param id the primary key of the entity stored in the corresponding table
     */
    void delete(final Serializable id);

    /**
     * Returns the entity of type T with the primary key.
     *
     * @param id the primary key of the entity stored in the corresponding table
     * @return the entity
     */
    T get(final Serializable id);

    /**
     * Returns an ordered range of all the entities, those are stored in corresponding table.
     *
     * @return the ordered range of entities
     */
    List<T> getAll();

}
