package servlet;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import service.ServiceLocator;
import service.TariffService;
import service.UserService;

@WebListener
public class FrontServletContextListener implements ServletContextListener {
	// Prepare the EntityManagerFactory
	@Override
	public void contextInitialized(ServletContextEvent e) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("StudyWebApp.jpa");
		e.getServletContext().setAttribute("emf", emf);

		UserService userService = new UserService(emf);
		e.getServletContext().setAttribute("userService", userService);
		TariffService tariffService = new TariffService(emf);
		e.getServletContext().setAttribute("tariffService", tariffService);
		ServiceLocator serviceLocator = new ServiceLocator(
				e.getServletContext());
		e.getServletContext().setAttribute("serviceLocator", serviceLocator);

	}

	// Release the EntityManagerFactory:
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		EntityManagerFactory emf = (EntityManagerFactory) e.getServletContext()
				.getAttribute("emf");
		emf.close();
	}
}
