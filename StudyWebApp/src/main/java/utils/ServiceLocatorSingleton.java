package utils;

import service.IContractService;
import service.IOptionService;
import service.ITariffService;
import service.IUserService;
import service.impl.ContractService;
import service.impl.OptionService;
import service.impl.TariffService;
import service.impl.UserService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Initializes and stores services. Provides it by demand. Among services are:
 * entity manager factory, user service, tariff service, option service, contract service,
 * validator factory. Single entity of this class is created during <code>contextInitialized()</code> method call in
 * class <code>FrontServletContextListener</code>.
 *
 * @author Tatiana
 * @version 1.0
 */
public final class ServiceLocatorSingleton {
    /**
     * Stores registered objects - services. Each service stored under its key - Class of the entity.
     */
    private static Map<Class<?>, Object> services = Collections
            .synchronizedMap(new HashMap<Class<?>, Object>());

    /**
     * Single object. One per application. Statically initialized during class loading.
     */
    private static final ServiceLocatorSingleton SERVICE_LOCATOR;

    static {
        try {
            SERVICE_LOCATOR = new ServiceLocatorSingleton();
        } catch (Exception ex) {
            throw new IllegalStateException(
                    "Unable to create service locator: " + ex.getMessage(), ex);
        }
    }

    /**
     * Stores entity manager factory.
     */
    private EntityManagerFactory emf = null;
    /**
     * Stores user service.
     */
    private IUserService userService = null;
    /**
     * stores tariff service.
     */
    private ITariffService tariffService = null;
    /**
     * Stores option service.
     */
    private IOptionService optionService = null;
    /**
     * Stores contract service.
     */
    private IContractService contractService = null;
    /**
     * Stores validation factory.
     */
    private ValidatorFactory vf = null;

    /**
     * Constructor of this class.
     */
    private ServiceLocatorSingleton() {
        emf = Persistence
                .createEntityManagerFactory("StudyWebApp.jpa");
        userService = new UserService(emf);
        loadService(IUserService.class, userService);
        tariffService = new TariffService(emf);
        loadService(ITariffService.class, tariffService);
        optionService = new OptionService(emf);
        loadService(IOptionService.class, optionService);
        contractService = new ContractService(emf);
        loadService(IContractService.class, contractService);
        vf = Validation.buildDefaultValidatorFactory();
        loadService(ValidatorFactory.class, vf);
    }

    /**
     * Loads service to the map, in which all services are stored.
     *
     * @param key     is a key to find service in future.
     * @param service which is stored in map
     */
    void loadService(final Class<?> key, final Object service) {
        services.put(key, service);
    }

    /**
     * Gets service by incoming key.
     *
     * @param key is a clue for getting proper service from the services map.
     * @return service that corresponds key
     */
    public Object getService(final Class<?> key) {
        return services.get(key);
    }

    /**
     * Gets instance of service locator singleton. In this application called only
     * ones {@link servlet.FrontServletContextListener#contextInitialized(ServletContextEvent)}
     *
     * @return service locator singleton object
     */
    public static ServiceLocatorSingleton getInstance() {
        return SERVICE_LOCATOR;
    }

}
