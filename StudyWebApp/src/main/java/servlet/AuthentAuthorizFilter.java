package servlet;

import entity.User;
import utils.IAuthorizationManager;
import utils.ServiceLocatorSingleton;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Validates session to all the resources except UserLoginCommand and index.jsp, because it will not have a session.
 *
 * @author Tatiana
 * @version 1.0
 */
@WebFilter("/AuthentAuthorizFilter")
public class AuthentAuthorizFilter implements Filter {

    /**
     * Stores urls endings for those authentication  is not needed.
     */
    private ArrayList urlList;

    /**
     * Runs only once after first call to the filter servlet.
     *
     * @param fConfig filter configuration from file
     * @throws ServletException if some error this exception
     */
    public final void init(final FilterConfig fConfig) throws ServletException {

        // Read the URLs to be avoided for authentication check (From web.xml)
       /* String urls = fConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        urlList = new ArrayList();
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }*/
        urlList = new ArrayList();
        urlList.add("/StudyWebApp/");
        urlList.add("/login.jsp");
        urlList.add("/index.jsp");
        urlList.add("/UserLogin.go");
        urlList.add(".js");
        urlList.add(".css");
        urlList.add(".png");

    }

    /**
     * Main method of the filter. Contains work that filter is doing.
     * Here authentication and authorization work is been doing.
     *
     * @param req   servlet request
     * @param res   servlet response
     * @param chain chain of filters to process
     * @throws IOException      if IO exception
     * @throws ServletException if error with servlet
     */
    public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getServletPath();
        boolean allowedRequest = false;
        // String uri = request.getRequestURI();
        String strURL = "";


        // To check if the url can be excluded or not
        for (int i = 0; i < urlList.size(); i++) {
            strURL = urlList.get(i).toString();
            if (url.endsWith(strURL)) {
                allowedRequest = true;
            }
        }

        // Will not create new session, if it does not exist, as "false" parameter is used
        HttpSession session = request.getSession(false);

        if (!allowedRequest) {
            if (session == null || session.getAttribute("user") == null) {

                request.setAttribute("ErrorMessage", "Unauthenticated access request");
                // Forward the control to login.jsp if authentication fails
                request.getRequestDispatcher("/login.jsp").forward(request,
                        response);
                return; //break filter chain, requested JSP/servlet will not be executed
            }

            //authorization check (check for corresponding rights)
            User currentUser = (User) session.getAttribute("user");

            //Get relevant URI.
            String uri = ((HttpServletRequest) request).getRequestURI();

            //Obtain AuthorizationManager singleton from ServiceLocatorSingleton
            IAuthorizationManager authMgr =
                    (IAuthorizationManager) ServiceLocatorSingleton.getInstance().getService(IAuthorizationManager.class);

            //Invoke AuthorizationManager method to see if user can access resource.
            boolean authorized = authMgr.isUserAuthorized(currentUser, uri);
            if (!authorized) {

                request.setAttribute("ErrorMessage", "User is not authorized to access this area!");
                request.setAttribute("HttpStatus", "401");

                // Forward the control to error.jsp if authentication fails
                request.getRequestDispatcher("/error.jsp").forward(request,
                        response);
                return; //break filter chain, requested JSP/servlet will not be executed

            }
        }

        chain.doFilter(request, response);
    }

    /**
     * Method runs once after filter life is over. Here in future we will remove all used resources.
     */
    public void destroy() {
        //close any resources here
    }
}
