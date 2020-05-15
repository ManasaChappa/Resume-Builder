package coreservlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/")
public class UserSkillController extends HttpServlet {
	
	private UserLoginDAO userDAO = new UserLoginDAO();
	 
	  @Override         
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	      throws ServletException, IOException {
	    
		  String action = request.getServletPath();

	        try {
	            switch (action) {
	                case "/new":
	                    showNewForm(request, response);
	                    break;
	                case "/insert":
	                    insertUserSkill(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateUserSkill(request, response);
	                    break;
	                case "/delete":
	                    deleteSkill(request, response);
	                    break;
	                case "/newedu":
	                    showNeweduForm(request, response);
	                    break;
	                case "/insertedu":
	                    insertEducation(request, response);
	                    break;
	                case "/listedu":
	                	listEducation(request, response);
	                  break;
	                case "/editedu":
	                	showEduForm(request, response);
	                    break;
	                case "/updateedu":
	                    updateEducation(request, response);
	                    break;
	                case "/deleteedu":
	                    deleteEducation(request, response);
	                    break;
	                case "/newwork":
	                    showNewworkform(request, response);
	                    break;
	                case "/insertwork":
	                    inserWorkhistory(request, response);
	                    break;
	                case "/listwork":
	                	listWork(request, response);
	                  break;
	                case "/editwork":
	                	showeditWorkForm(request, response);
	                    break;
	                case "/updatework":
	                    updateWork(request, response);
	                    break;
	                case "/deletework":
	                	deleteWork(request, response);
	                    break;
	                default:
	                    listUser(request, response);
	                    break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	    }
	  
	  private void showNewworkform(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("userworkhistory.jsp");
			  dispatcher.forward(request, response);
		}
	  
	  private void showNeweduForm(HttpServletRequest request, HttpServletResponse response)
			    throws ServletException, IOException {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("usereducation.jsp");
			  dispatcher.forward(request, response);
			}
	  
	  private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
		    String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies)
				{
					if (c.getName().equals("username")) {
						username = c.getValue();
					}
				}
				}
		  	List<UserSkill> listSkill;
		  	listSkill = userDAO.listSkills(username);
			request.setAttribute("UserSkill", listSkill);			
			RequestDispatcher dispatcher = request.getRequestDispatcher("userskills.jsp");
			dispatcher.forward(request, response);
			
		 }

		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("userskillform.jsp");
			  dispatcher.forward(request, response);
		}      
	        
		private void insertUserSkill(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, IOException {
			    
			String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null)
			 {
			    for (Cookie c : cookies) {
			    if (c.getName().equals("username")) {
			    	username = c.getValue();
				}    			
			  }		    			
			String skill = request.getParameter("txtSkill");
  			UserSkill newSkill = new UserSkill(0,username,skill);
			userDAO.insertSkill(newSkill);
			response.sendRedirect("list");
		}
		}
		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
			   int id = Integer.parseInt(request.getParameter("id"));
			   UserSkill existSkill = userDAO.getUserSkill(id);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("userskillform.jsp");
			   request.setAttribute("existSkill", existSkill);
			   dispatcher.forward(request, response);
			    	    }
		
			    	private void showeditWorkForm(HttpServletRequest request, HttpServletResponse response)
				    	    throws SQLException, ServletException, IOException {
				    	        int id = Integer.parseInt(request.getParameter("id"));
				    	        Workhistory existWork = userDAO.getWorkhistory(id);
				    	        RequestDispatcher dispatcher = request.getRequestDispatcher("userworkform.jsp");
				    	        request.setAttribute("exisWork", existWork);
				    	        dispatcher.forward(request, response);

				    	    }
				    
	private void updateUserSkill(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username")) {
						username = c.getValue();
					}
				}
			}
	        String uskill = request.getParameter("txtSkill");
	        UserSkill skill = new UserSkill(id,username,uskill);
	        userDAO.updateSkill(skill);
	        response.sendRedirect("list");
	    }
	private void updateWork(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String username = null;
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie c : cookies) {
						if (c.getName().equals("username")) {
							username = c.getValue();
						}
					}
				}
				String JobTitle = request.getParameter("JobTitle");
    			String JobEmployer = request.getParameter("JobEmployer");
    			String JobCity = request.getParameter("JobCity");
    			String JobState = request.getParameter("JobState");
    			String stdate =request.getParameter("stdate");
    			Date startdt =null;
				try {
					startdt = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(stdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			String enddate =request.getParameter("enddate");
    			Date eddate=null;
				try {
					eddate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(enddate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
    			int iscurrent = Integer.parseInt(request.getParameter("iscurrent"));

    			Workhistory newWork = new Workhistory(id,username,JobTitle,JobEmployer,JobCity,JobState,startdt,eddate,iscurrent);
		        response.sendRedirect("listwork");

		    }
	private void deleteSkill(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        userDAO.deleteSkill(id);
		        response.sendRedirect("list");

		    }
	  private void insertEducation(HttpServletRequest request, HttpServletResponse response)
	    	    throws SQLException, IOException {
	    			String username = null;
	    			Cookie[] cookies = request.getCookies();
	    			if (cookies != null) {
	    				for (Cookie c : cookies) {
	    					if (c.getName().equals("username")) {
	    						username = c.getValue();
	    					}
	    				}
	    			}		    			
	    			String Degree = request.getParameter("txtDegree");
	    			String sname = request.getParameter("txtSchoolName");
	    			String slocation = request.getParameter("txtSchoolLocation");
	    			String gmonth = request.getParameter("cmbMonth");
	    			String gYear = request.getParameter("cmbYear");
	    			String Major = request.getParameter("txtMajor");
	    			Education newEdu = new Education(0, username, Degree, sname, slocation, gmonth,  gYear, Major);
	    			userDAO.insertUserEducation(newEdu);
	    	        response.sendRedirect("listedu");
	    	    }
	  private void listEducation(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
		    	
		  		//HttpSession session = request.getSession();
		  		//String username = (String) request.getAttribute("user");
		  	String username = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("username")) {
						username = c.getValue();
					}
				}
				}
		  		List<Education> listEdu;
		  		listEdu = userDAO.listEducation(username);
				request.setAttribute("UserEdu", listEdu);			
				RequestDispatcher dispatcher = request.getRequestDispatcher("useredulist.jsp");
			    dispatcher.forward(request, response);
			    }
	  
	  
	 
			    	private void showEduForm(HttpServletRequest request, HttpServletResponse response)
			    	    throws SQLException, ServletException, IOException {
			    	        int id = Integer.parseInt(request.getParameter("id"));
			    	        Education existEdu = userDAO.getEducation(id);
			    	        RequestDispatcher dispatcher = request.getRequestDispatcher("usereducation.jsp");
			    	        request.setAttribute("existEdu", existEdu);
			    	        dispatcher.forward(request, response);

			    	    }

			    	private void updateEducation(HttpServletRequest request, HttpServletResponse response)
			    		    throws SQLException, IOException {
			    		        int id = Integer.parseInt(request.getParameter("id"));
			    		        String username = null;
			    				Cookie[] cookies = request.getCookies();
			    				if (cookies != null) {
			    					for (Cookie c : cookies) {
			    						if (c.getName().equals("username")) {
			    							username = c.getValue();
			    						}
			    					}
			    				}
			    				String Degree = request.getParameter("txtDegree");
				    			String sname = request.getParameter("txtSchoolName");
				    			String slocation = request.getParameter("txtSchoolLocation");
				    			String gmonth = request.getParameter("cmbMonth");
				    			String gYear = request.getParameter("cmbYear");
				    			String Major = request.getParameter("txtMajor");
				    			Education existEdu = new Education(id, username, Degree, sname, slocation, gmonth,  gYear, Major);
				    					    		        
			    		        userDAO.updateUserEducation(existEdu);
			    		        response.sendRedirect("listedu");
			    		    }
			    		
			    		private void deleteEducation(HttpServletRequest request, HttpServletResponse response)
			    			    throws SQLException, IOException {
			    			        int id = Integer.parseInt(request.getParameter("id"));
			    			        userDAO.deleEdu(id);
			    			        response.sendRedirect("listedu");

			    			    }
			    		private void deleteWork(HttpServletRequest request, HttpServletResponse response)
			    			    throws SQLException, IOException {
			    			        int id = Integer.parseInt(request.getParameter("id"));
			    			        userDAO.deleteWork(id);
			    			        response.sendRedirect("listwork");

			    			    }
			    		 private void inserWorkhistory(HttpServletRequest request, HttpServletResponse response)
						    	    throws SQLException, IOException {
						    			String username = null;
						    			Cookie[] cookies = request.getCookies();
						    			if (cookies != null) {
						    				for (Cookie c : cookies) {
						    					if (c.getName().equals("username")) {
						    						username = c.getValue();
						    					}
						    				}
						    			}	
						    			int id=0;
						    			String JobTitle = request.getParameter("JobTitle");
						    			String JobEmployer = request.getParameter("JobEmployer");
						    			String JobCity = request.getParameter("JobCity");
						    			String JobState = request.getParameter("JobState");
						    			String stdate =request.getParameter("stdate");
						    			Date startdt =null;
										try {
											startdt = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(stdate);
										} catch (ParseException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
						    			String enddate =request.getParameter("enddate");
						    			Date eddate=null;
										try {
											eddate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(enddate);
										} catch (ParseException e) {
											e.printStackTrace();
										}
						    			int iscurrent = Integer.parseInt(request.getParameter("iscurrent"));

						    			Workhistory newWork = new Workhistory(id,username,JobTitle,JobEmployer,JobCity,JobState,startdt,eddate,iscurrent);
						    			
						    			userDAO.insertWorkhistory(newWork);
						    	        response.sendRedirect("listwork");
						    	    }
			    		 private void listWork(HttpServletRequest request, HttpServletResponse response)
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
			    			  		List<Workhistory> listWork;
			    			  		listWork = userDAO.listWork(username);
			    					request.setAttribute("UserWork", listWork);			
			    					RequestDispatcher dispatcher = request.getRequestDispatcher("userworkhistory.jsp");
			    				    dispatcher.forward(request, response);
			    				    }
}
 


