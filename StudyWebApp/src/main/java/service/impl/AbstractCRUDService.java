package service.impl;

import service.BaseService;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Tatiana on 07.06.2015.
 */
public class AbstractCRUDService<T> implements BaseService<T> {

    private EntityManagerFactory emf = null;

    private Class<T> clazz;

    protected AbstractCRUDService(final Class<T> clazz, EntityManagerFactory emf) {
        this.clazz = clazz;
        this.emf = emf;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("SELECT t FROM " + clazz.getName() + " t");
        List<T> entities = query.getResultList();

        em.close();
        return entities;
    }

    public T get(final Serializable id) {
        EntityManager em = emf.createEntityManager();

        T entity = em.find(clazz, id);
        if (entity == null) {
            throw new EntityNotFoundException("Can't find " + clazz.getName() + " for ID "
                    + id);
        }
        em.close();
        return entity;
    }

    public void delete(final Serializable id) {
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

    public T update(final T entity) {
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
            if (tx != null)
                tx.rollback();
        } finally {
            em.close();
        }
        return storedEntity;
    }

    public void add(T entity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = null;

        try {
            tx = em.getTransaction();
            tx.begin();
            em.persist(entity);
            tx.commit();
        } catch (PersistenceException pex) {
            pex.printStackTrace();
            if (tx != null)
                tx.rollback();
        } finally {
            em.close();

        }
    }
}
