package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public class ListServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;



		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)

		throws ServletException, IOException {

			List<User> userList = populate();
			 HttpSession session = req.getSession();
			 session.setAttribute("userList", userList); 
			 getServletContex().getRequestDispatcher("/list.jsp");

		}
		
		public List<User> populate(){
			List<User> userList = new ArrayList<User>();
			User user1 = new User();
			user1.setName("Vasya");
			user1.setAge(13);
			userList.add(user1);
			User user2 = new User();
			user2.setName("Petya");
			user2.setAge(19);
			userList.add(user2);

			return userList;
			}

	}
