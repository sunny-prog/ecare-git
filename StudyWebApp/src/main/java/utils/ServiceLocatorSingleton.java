package utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import service.IContractService;
import service.IOptionService;
import service.ITariffService;
import service.IUserService;
import service.impl.ContractService;
import service.impl.OptionService;
import service.impl.TariffService;
import service.impl.UserService;

public class ServiceLocatorSingleton {
	private static Map<Class<?>, Object> services = Collections
			.synchronizedMap(new HashMap<Class<?>, Object>());

	private static final ServiceLocatorSingleton serviceLocator;

	static {
		try {
			serviceLocator = new ServiceLocatorSingleton();
		} catch (Exception ex) {
			throw new IllegalStateException(
					"Unable to create service locator: " + ex.getMessage(), ex);
		}
	}

	EntityManagerFactory emf = null;
	private IUserService userService = null;
	private ITariffService tariffService = null;
	private IOptionService optionService = null;
	private IContractService contractService = null;

	private ServiceLocatorSingleton() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("StudyWebApp.jpa");
		userService = new UserService(emf);
		loadService(IUserService.class, userService);
		tariffService = new TariffService(emf);
		loadService(ITariffService.class, tariffService);
		optionService = new OptionService(emf);
		loadService(IOptionService.class, optionService);
		contractService = new ContractService(emf);
		loadService(IContractService.class, contractService);
	}

	void loadService(Class<?> key, Object service) {
		services.put(key, service);
	}

	public Object getService(Class<?> key) {
		return services.get(key);
	}

	public static ServiceLocatorSingleton getInstance() {
		return serviceLocator;
	}

}
