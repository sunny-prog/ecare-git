package service.impl;

import service.BaseService;

import java.io.Serializable;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Provides the service for creating, reading, updating, deleting (CRUD) entities type of T.
 * EntityManagerFactory is used to get EntityManager instance, that is used to make all previously listed operations.
 *
 * @param <T> could be any type (User, Option, etc), which has corresponding table in the DB.
 * @author Tatiana
 * @version 1.0
 */
public abstract class AbstractCRUDService<T> implements BaseService<T> {

    /**
     * Entity manager factory that is initialized during application start-up {@link utils.ServiceLocatorSingleton#getInstance()}.
     */
    private EntityManagerFactory emf = null;
    /**
     * Specifies class type on which processing is doing.
     */
    private Class<T> clazz;

    /**
     * Constructs a service object with the clazz entity type and entity manager factory.
     *
     * @param clazz type of entity to process
     * @param emf   the entity manager factory
     */
    protected AbstractCRUDService(final Class<T> clazz, final EntityManagerFactory emf) {
        this.clazz = clazz;
        this.emf = emf;
    }

    /**
     * Returns an ordered range of all the entities, those are stored in corresponding table.
     *
     * @return the ordered range of entities
     */
    @SuppressWarnings("unchecked")
    public final List<T> getAll() {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT t FROM " + clazz.getName() + " t");
        List<T> entities = query.getResultList();

        em.close();
        return entities;
    }

    /**
     * Returns the entity of type T with the primary key.
     *
     * @param id the primary key of the entity stored in the corresponding table
     * @return the entity
     */
    public final T get(final Serializable id) {
        EntityManager em = emf.createEntityManager();

        T entity = em.find(clazz, id);
        if (entity == null) {
            throw new EntityNotFoundException("Can't find " + clazz.getName() + " for ID "
                    + id);
        }
        em.close();
        return entity;
    }

    /**
     * Deletes the entity of type T with the primary key.
     *
     * @param id the primary key of the entity stored in the corresponding table
     */
    public final void delete(final Serializable id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        try {
            // Instantiate a transaction
            tx = em.getTransaction();
            tx.begin();
            T entity = em.find(clazz, id);
            if (entity == null) {
                throw new EntityNotFoundException("Can't find " + clazz.getName() + " for ID "
                        + id);
            }
            em.remove(entity);
            tx.commit();
        } catch (PersistenceException pex) {
            pex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

    /**
     * Updates the entity of type T.
     *
     * @param entity the entity of type T stored in the corresponding table
     * @return the entity
     */
    public final T update(final T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;
        T storedEntity = null;
        try {
            tx = em.getTransaction();
            tx.begin();
            storedEntity = em.merge(entity);
            tx.commit();
        } catch (PersistenceException pex) {
            pex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
        return storedEntity;
    }

    /**
     * Adds an entity.
     *
     * @param entity is the entity of type T that will be added the corresponding table
     */
    public final void add(final T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (PersistenceException pex) {
            pex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            em.close();

        }
    }
}
