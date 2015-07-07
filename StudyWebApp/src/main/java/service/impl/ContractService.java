package service.impl;

import entity.Contract;
import service.IContractService;

import javax.persistence.EntityManagerFactory;

/**
 * Provides the local service for creating, reading, updating, deleting (CRUD) contracts.
 *
 * @author Tatiana
 * @version 1.0
 */
public class ContractService extends AbstractCRUDService<Contract> implements IContractService {
    /**
     * Entity manager factory that is initialized during application start-up {@link utils.ServiceLocatorSingleton#getInstance()}.
     */
    private EntityManagerFactory emf = null;

    /**
     * Class constructor.
     *
     * @param emf entity manager factory
     */
    public ContractService(final EntityManagerFactory emf) {
        super(Contract.class, emf);
        this.emf = emf;
    }
}
