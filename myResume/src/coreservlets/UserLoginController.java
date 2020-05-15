package coreservlets;


import java.io.*;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/user")
public class UserLoginController extends HttpServlet {
  private UserLoginDAO userLogin = new UserLoginDAO();
  @Override         
  public void doPost(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    
	String UserName = request.getParameter("txtUserName");
	
    String Password = request.getParameter("txtPass");
    boolean login = false;
    String address;

    if (UserName!=null)
    {
    	login = userLogin.UserLogin(UserName, Password);
    	request.setAttribute("user", UserName);  
    	Cookie usernamecookie = new Cookie("username", UserName);    
    	response.addCookie(usernamecookie);
    	if (login == true) { 
    		UserProfile listUser = userLogin.getUserProfile(UserName);
    		request.setAttribute("UserProfile", listUser);
    		address = "userprofile.jsp";
    	   	
    	}else {
    		address =  "login.jsp";
    	}
    }
    else    
    {
    	address =  "userprofile.jsp";
    }
    
    
    List<State> listState;
	try {
		listState = userLogin.listStates();
	    request.setAttribute("State", listState);

	} catch (SQLException e) {
		e.printStackTrace();
	}
    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}