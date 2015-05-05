package service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import service.IOptionService;
import entity.Option;

public class OptionService implements IOptionService {
	private EntityManagerFactory emf = null;

	public OptionService(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	public List<Option> getAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM Option t");
		List<Option> options = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return options;
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
	public Option getOptionById(Long optionId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Option option = em.find(Option.class, optionId);
		if (option == null) {
			throw new EntityNotFoundException("Can't find Option for ID "
					+ optionId);
		}
		em.getTransaction().commit();
		em.close();
		return option;
	}

	/**
	 * Delete artist by their Id.
	 *
	 * @param artistId
	 *            the artist Id.
	 */
	public void deleteOptionById(Long optionId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Option option = em.find(Option.class, optionId);
		if (option == null) {
			throw new EntityNotFoundException("Can't find Option for ID "
					+ optionId);
		}
		em.remove(option);
		em.getTransaction().commit();
		em.close();
	}

}
