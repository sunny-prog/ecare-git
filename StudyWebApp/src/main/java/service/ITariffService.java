package service;

import java.util.List;
import entity.Tariff;

public interface ITariffService {
	public List<Tariff> getAll();

	public Tariff getTariffById(Long tariffId);

	public void deleteTariffById(Long tariffId);
}
