package command;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ServiceLocator;

public abstract class FrontCommand{
    private ServletContext context = null;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    protected ServiceLocator serviceLocator = null;

    public void init(ServletContext context, HttpServletRequest request, HttpServletResponse response) {
        this.context = context;
        this.request = request;
        this.response = response; 
        this.serviceLocator = (ServiceLocator) context.getAttribute("serviceLocator"); 
    }

    public abstract void execute() throws ServletException, IOException ;
    
    public void forward(String target) throws ServletException, IOException {
        RequestDispatcher dispatcher = this.context.getRequestDispatcher(target) ;
        dispatcher.forward(this.request, this.response); 
    }
     public ServletContext getContext() {
        return this.context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public HttpServletRequest getRequest() {
        return this.request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return this.response;
    }

     public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}