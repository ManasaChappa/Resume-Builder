package coreservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/newuser")
public class newusercontroller extends HttpServlet {
  private UserLoginDAO userLogin = new UserLoginDAO();
  @Override         
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
	  List<State> listState;
		try {
			listState = userLogin.listStates();
		    request.setAttribute("State", listState);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String address="userprofile.jsp";
	    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
	    dispatcher.forward(request, response);
  }
  }