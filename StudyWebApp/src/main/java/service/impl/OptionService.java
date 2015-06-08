package service.impl;

import javax.persistence.*;

import service.IOptionService;
import entity.Option;

public class OptionService extends AbstractCRUDService<Option> implements IOptionService {
    private EntityManagerFactory emf = null;

    public OptionService(EntityManagerFactory emf) {
        super(Option.class, emf);
        this.emf = emf;
    }


}
