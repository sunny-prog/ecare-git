package service.impl;

import javax.persistence.EntityManagerFactory;

import service.ITariffService;
import entity.Tariff;
/**
 * Provides the local service for creating, reading, updating, deleting (CRUD) tariffs.
 *
 * @author Tatiana
 * @version 1.0
 */
public class TariffService extends AbstractCRUDService<Tariff> implements ITariffService {
    /**
     * Entity manager factory that is initialized during application start-up {@link utils.ServiceLocatorSingleton#getInstance()}.
     */
    private EntityManagerFactory emf = null;
    /**
     * Class constructor.
     * @param emf entity manager factory
     */
    public TariffService(final EntityManagerFactory emf) {
        super(Tariff.class, emf);
        this.emf = emf;
    }
}
