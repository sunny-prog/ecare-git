package servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.ServiceLocatorSingleton;

/**
 * Receives notification events about ServletContext lifecycle.
 * Code inside this class will run before the web application starts.
 *
 * @author Tatiana
 * @version 1.0
 */
@WebListener
public class FrontServletContextListener implements ServletContextListener {

    @Override
    public final void contextInitialized(final ServletContextEvent e) {
        // Prepare the service locator with services and EntityManagerFactory
        // and ValidationFactory and Authorization Manager
        // as ServiceLocatorSingleton object is static it will be initialized when class is loaded.
        // When we will call getInstance method instance of ServiceLocatorSingleton will be already created.
        // One single instance of ServiceLocatorSingleton will be returned to us.
        ServiceLocatorSingleton.getInstance();
    }

    // Release the EntityManagerFactory:
    @Override
    public void contextDestroyed(final ServletContextEvent e) {
    }
}
