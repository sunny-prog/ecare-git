package service;

import javax.servlet.ServletContext;

public class ServiceLocator {

	private final ServletContext context;

	@SuppressWarnings("unchecked")
	public <T> T getService(String name) {
		return (T) context.getAttribute(name);
	}

	public ServiceLocator(ServletContext context) {
		this.context = context;
	}

}