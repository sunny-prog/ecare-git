package dao;

import java.util.List;
import entity.Tariff;

public interface TariffDAO {

    Tariff getTariffById(Long id);
    boolean delete(Long id);
    boolean add(Tariff tariff);
    List<Tariff> getAll();
}