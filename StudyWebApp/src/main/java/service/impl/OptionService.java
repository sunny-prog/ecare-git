package service.impl;

import javax.persistence.EntityManagerFactory;

import service.IOptionService;
import entity.Option;
/**
 * Provides the local service for creating, reading, updating, deleting (CRUD) options.
 *
 * @author Tatiana
 * @version 1.0
 */
public class OptionService extends AbstractCRUDService<Option> implements IOptionService {
    /**
     * Entity manager factory that is initialized during application start-up {@link utils.ServiceLocatorSingleton#getInstance()}.
     */
    private EntityManagerFactory emf = null;
    /**
     * Class constructor.
     * @param emf entity manager factory
     */
    public OptionService(final EntityManagerFactory emf) {
        super(Option.class, emf);
        this.emf = emf;
    }
}
