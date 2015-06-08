package service.impl;

import javax.persistence.EntityManagerFactory;

import service.ITariffService;
import entity.Tariff;

public class TariffService extends AbstractCRUDService<Tariff> implements ITariffService {
    private EntityManagerFactory emf = null;

    public TariffService(EntityManagerFactory emf) {
        super(Tariff.class, emf);
        this.emf = emf;
    }
}
