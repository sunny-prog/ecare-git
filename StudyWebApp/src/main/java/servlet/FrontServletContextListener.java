package servlet;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import utils.ServiceLocatorSingleton;

@WebListener
public class FrontServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent e) {
		// Prepare the service locator with services and EntityManagerFactory
		ServiceLocatorSingleton.getInstance();
	}

	// Release the EntityManagerFactory:
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		EntityManagerFactory emf = (EntityManagerFactory) e.getServletContext()
				.getAttribute("emf");
		emf.close();
	}
}
