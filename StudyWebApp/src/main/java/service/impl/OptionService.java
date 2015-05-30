package service.impl;

import java.util.List;

import javax.persistence.*;

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

	public void deleteOptionById(Long optionId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			// Instantiate a transaction
			tx = em.getTransaction();
			tx.begin();
			Option option = em.find(Option.class, optionId);
			if (option == null) {
				throw new EntityNotFoundException("Can't find Option for ID "
						+ optionId);
			}
			em.remove(option);
			tx.commit();
		} catch (PersistenceException pex) {
			pex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}

		} finally {


			em.close();
		}

	}


	public Option updateOption(Option option) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		Option storedOption = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Long optionId = option.getId();
			// find() and update() in the same transaction
			Option foundOption = em.find(Option.class, optionId);
			if (foundOption == null) {
				throw new EntityNotFoundException("Can't find Option for ID "
						+ optionId);
			}
			storedOption = em.merge(option);
			tx.commit();
		} catch (PersistenceException pex) {
			pex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			em.close();
		}
		return storedOption;
	}

	public void addOption(Option option) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;

		Option storedOption = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(option);
			tx.commit();
		} catch (PersistenceException pex) {
			pex.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			em.close();

		}
	}
}
