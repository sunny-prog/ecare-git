package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import entity.Tariff;

public class TariffService {
	private EntityManagerFactory emf = null;

	public TariffService(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	public List<Tariff> getAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM Tariff t");
		List<Tariff> tariffs = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return tariffs;
	}

	/**
	 * Find User based on the entity Id.
	 *
	 * @param userId
	 *            the user Id.
	 * @return User.
	 * @throws EntityNotFoundException
	 *             when no user is found.
	 */
	public Tariff getTariffById(Long tariffId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Tariff tariff = em.find(Tariff.class, tariffId);
		if (tariff == null) {
			throw new EntityNotFoundException("Can't find Tariff for ID "
					+ tariffId);
		}
		em.getTransaction().commit();
		em.close();
		return tariff;
	}

	/**
	 * Delete artist by their Id.
	 *
	 * @param artistId
	 *            the artist Id.
	 */
	public void deleteTariffById(Long tariffId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Tariff tariff = em.find(Tariff.class, tariffId);
		if (tariff == null) {
			throw new EntityNotFoundException("Can't find Tariff for ID "
					+ tariffId);
		}
		em.remove(tariff);
		em.getTransaction().commit();
		em.close();
	}
}
