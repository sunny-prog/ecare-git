package service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import service.IContractService;
import service.IOptionService;
import entity.Contract;
import entity.Option;


public class ContractService extends AbstractCRUDService<Contract> implements IContractService {
    private EntityManagerFactory emf = null;

    public ContractService(EntityManagerFactory emf) {
        super(Contract.class, emf);
        this.emf = emf;
    }
}
