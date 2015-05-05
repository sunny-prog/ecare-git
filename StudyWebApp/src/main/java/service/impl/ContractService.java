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

public class ContractService implements IContractService{
	private EntityManagerFactory emf = null;

	public ContractService(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	@SuppressWarnings("unchecked")
	public List<Contract> getAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM Contract t");
		List<Contract> options = query.getResultList();
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
	public Contract getContractById(Long contractId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contract contract = em.find(Contract.class, contractId);
		if (contract == null) {
			throw new EntityNotFoundException("Can't find Contract for ID "
					+ contractId);
		}
		em.getTransaction().commit();
		em.close();
		return contract;
	}

	/**
	 * Delete artist by their Id.
	 *
	 * @param artistId
	 *            the artist Id.
	 */
	public void deleteContractById(Long contractId) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Contract contract = em.find(Contract.class, contractId);
		if (contract == null) {
			throw new EntityNotFoundException("Can't find Contract for ID "
					+ contractId);
		}
		em.remove(contract);
		em.getTransaction().commit();
		em.close();
	}

}
