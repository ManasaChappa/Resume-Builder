package coreservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/userprofile_view")
public class userprofileview extends HttpServlet {
	 private UserLoginDAO userDAO = new UserLoginDAO();
	
	  @Override         
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	      throws ServletException, IOException {

		 // String username = request.getParameter("txtUserName");
		  
		  String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username")) {
						username = c.getValue();
					}
				}
				}
		 
		  UserProfile listUser = userDAO.getUserProfile(username);
		  
		  List<UserSkill> listSkill;
		try {
			listSkill = userDAO.listSkills(username);
			request.setAttribute("UserSkill", listSkill);
			request.setAttribute("UserProfile", listUser);
	    	//address = "userprofile.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		 String address = "userprofile.jsp";
	     RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	     dispatcher.forward(request, response);
	  }

}
