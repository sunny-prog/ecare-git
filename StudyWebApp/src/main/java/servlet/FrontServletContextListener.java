package servlet;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
@WebListener
public class FrontServletContextListener implements ServletContextListener {
	// Prepare the EntityManagerFactory
	@Override
	public void contextInitialized(ServletContextEvent e) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("StudyWebApp.jpa");
		e.getServletContext().setAttribute("emf", emf);
	}

	// Release the EntityManagerFactory:
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		EntityManagerFactory emf = (EntityManagerFactory) e.getServletContext()
				.getAttribute("emf");
		emf.close();
	}
}
