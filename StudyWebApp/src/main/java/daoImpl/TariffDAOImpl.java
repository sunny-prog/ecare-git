package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.TariffDAO;
import entity.Tariff;

public class TariffDAOImpl implements TariffDAO {

	private static List<Tariff> tariffs;

	static {
		tariffs = new ArrayList<Tariff>();
		tariffs.add(new Tariff(1L, Integer.valueOf(50), "Simple"));
		tariffs.add(new Tariff(2L, Integer.valueOf(17), "Easy"));
		tariffs.add(new Tariff(3L, Integer.valueOf(22), "One"));
		tariffs.add(new Tariff(4L, Integer.valueOf(25), "RoundTrip"));
		tariffs.add(new Tariff(5L, Integer.valueOf(31), "Cristmas"));
	}

	@Override
	public Tariff getTariffById(Long id) {
		for (Tariff tariff : tariffs) {
			if (tariff.getId().equals(id)) {
				return tariff;
			}
		}
		return null;
	}

	@Override
	public List<Tariff> getAll() {
		return tariffs;
	}

	@Override
	public boolean delete(Long id) {
		Tariff tariffToRemove = null;
		for (Tariff tariff : tariffs) {
			if (tariff.getId().equals(id)) {
				tariffToRemove = tariff;
				break;
			}
		}
		if (tariffToRemove != null) {
			return tariffs.remove(tariffToRemove);
		}
		return false;
	}

	@Override
	public boolean add(Tariff tariff) {
		return tariffs.add(tariff);
	}
}