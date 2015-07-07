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
		// and ValidationFactory
		ServiceLocatorSingleton.getInstance();
	}

	// Release the EntityManagerFactory:
	@Override
	public void contextDestroyed(final ServletContextEvent e) {
	}
}
