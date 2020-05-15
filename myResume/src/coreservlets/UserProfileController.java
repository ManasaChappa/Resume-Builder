package coreservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/userprofile_submit")
public class UserProfileController extends HttpServlet {
	 private UserLoginDAO userDAO = new UserLoginDAO();
	
	  @Override         
	  public void doPost(HttpServletRequest request,
	                    HttpServletResponse response)
	      throws ServletException, IOException {

		 String mode = request.getParameter("hdnMode");
	
		 try {
	            switch (mode) {
	                case "0":
	                    insertUserProfile(request, response);
	                    break;
	                case "1":
	                    updateUserProfile(request, response);
	                    break;	                               	
	           }
	            
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
		 
	  
	  private void insertUserProfile(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
		  
		  	String username=request.getParameter("txtUserName");	
		  	String FirstName=request.getParameter("txtFirstName") ;
		  	String LastName= request.getParameter("txtLastName") ;
		  	String MiddleName= request.getParameter("txtMiddleName");
		  	String Address=request.getParameter("txtAddress");
		  	String Address2=request.getParameter("txtAddress2") ;
		  	String City=request.getParameter("txtCity");
		  	String State=request.getParameter("cmbState");
		  	String Zip= request.getParameter("txtZip");	    			
	    	String pwd = request.getParameter("txtPassword");
		  	
		  	 UserProfile user = new UserProfile(username, pwd,FirstName, LastName, MiddleName, Address, Address2, State, City,  Zip);
			 boolean inserted = userDAO.InsertUser(user);
			 if (inserted == true)
			 {
				 UserProfile listUser = userDAO.getUserProfile(username);
			    request.setAttribute("UserProfile", listUser);
			    	
			 }
			 String address = "login.jsp";
		     RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		     dispatcher.forward(request, response);
	    	}
	  
	  private void updateUserProfile(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException, ServletException {
		  
		  String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username")) {
						username = c.getValue();
					}
				}
				}
		  String FirstName=request.getParameter("txtFirstName") ;
		  String LastName= request.getParameter("txtLastName") ;
		  String MiddleName= request.getParameter("txtMiddleName");
		  String Address=request.getParameter("txtAddress");
		  String Address2=request.getParameter("txtAddress2") ;
		  String City=request.getParameter("txtCity");
		  String State=request.getParameter("cmbState");
		  String Zip= request.getParameter("txtZip");
		  String pwd = request.getParameter("txtPassword");
		  	
		 UserProfile user = new UserProfile(username, pwd,FirstName, LastName, MiddleName, Address, Address2, State, City,  Zip);
		 userDAO.updateUser(user);
		  
		  List<UserSkill> listSkill;
		try {
			listSkill = userDAO.listSkills(username);
			request.setAttribute("UserSkill", listSkill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		  
		 String address = "userskills.jsp";
	     RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	     dispatcher.forward(request, response);
	  }
}
