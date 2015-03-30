package service;

import java.util.List;

import dao.TariffDAO;
import daoImpl.TariffDAOImpl;
import entity.Tariff;

public class TariffService {

	TariffDAO dao = new TariffDAOImpl();

	public List<Tariff> getAll() {
		return dao.getAll();
	}

	public void delete(Long id) {
		dao.delete(id);
	}

}
