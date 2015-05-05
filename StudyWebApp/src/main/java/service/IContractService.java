package service;

import java.util.List;
import entity.Contract;

public interface IContractService {
	public List<Contract> getAll();

	public Contract getContractById(Long contractId);

	public void deleteContractById(Long contractId);
}
