package coreservlets;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserLoginDAO {
	public Connection getconnection() throws ClassNotFoundException
	{
	    java.sql.Connection con = null;
	   

		try {
			 Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myResume","root","Manu02!cm");		    
		  }
		  catch(SQLException e) {
		    System.out.println("SQLException caught: " +e.getMessage());
		  }
	    return con;
	}
	
	public boolean UserLogin(String user, String Password) {
		boolean status = false;
		try{  
			Connection con=getconnection();  			            
			PreparedStatement ps=con.prepareStatement(  
			    "select user_name,user_password from user_profile where user_name=? and user_password=?"); 			  
			ps.setString(1,user);  
			ps.setString(2, Password);  			              
			ResultSet rs=ps.executeQuery();  
			status=rs.next();  
			rs.close();
			disconnect(con);
		 }catch(Exception e){
			 System.out.println(e.getMessage());
			 
		 }  
			  
			return status;  
			  
	}
	
	public UserProfile getUserProfile(String username) {
		UserProfile user = null;
		try{  
			Connection con=getconnection();  			            
			PreparedStatement ps=con.prepareStatement(  
			    "select * from user_profile where user_name=?"); 			  
			ps.setString(1,username);  				              
			ResultSet rs=ps.executeQuery();  
			if (rs.next()) {
				user = new UserProfile();
				user.setUserName(rs.getString("user_name"));
				user.setFirstName(rs.getString("user_fname"));
				user.setLastName(rs.getString("user_lname"));
	       			user.setMiddleName(rs.getString("user_mname"));
				user.setPassword(rs.getString("user_password"));
				user.setAddress(rs.getString("user_Address"));
				user.setAddress1(rs.getString("user_Address2"));
				user.setCity(rs.getString("user_City"));
				user.setStateID(rs.getString("user_State"));
				user.setZipcode(rs.getString("user_Zipcode"));
						}
			rs.close();
			disconnect(con);
		}catch(Exception e){
			 System.out.println(e.getMessage());
			 
		 }  
        return user;
        
			  
	}
	public List<State> listStates() throws SQLException {
        List<State> listState = new ArrayList<>();
         
        String sql = "SELECT * FROM state";
         
       Connection con=null;
       try {
    	   con = getconnection();
    	   Statement statement = con.createStatement();
    	   ResultSet resultSet = statement.executeQuery(sql);
    	   while (resultSet.next()) {
    		   String statecode = resultSet.getString("state_code");
    		   String statename = resultSet.getString("state_name");
    		   int stateid=resultSet.getInt("state_id");             
    		   State st = new State(stateid,statename,statecode);
    		   listState.add(st);
    	   	}
    	   resultSet.close();
    	   statement.close();
    	   disconnect(con);
       		} catch (ClassNotFoundException e) {
       			e.printStackTrace();
       		}
       catch (SQLException e) {
  			e.printStackTrace();
  		}  
         return listState;
    }
	public void disconnect(Connection con) throws SQLException {
		con.close();
	}
	public boolean updateUser(UserProfile user) {
		
		String sql = "update user_profile set  user_fname=?, user_lname=?, user_mname=?,user_Address=?,user_Address2=?,user_City=?,user_State=?,user_Zipcode=?  where user_name = ?";
		Connection con = null;
		boolean rowUpdated = false;
		try {
			con = getconnection();
			PreparedStatement statement = con.prepareStatement(sql);
	        statement.setString(1, user.getFirstName());
	        statement.setString(2, user.getLastName());
	        statement.setString(3, user.getMiddleName());
	        statement.setString(4, user.getAddress());
	        statement.setString(5, user.getAddress1());
	        statement.setString(6, user.getCity());
	        statement.setString(7, user.getStateID());
	        statement.setString(8, user.getZipcode());
	        statement.setString(9, user.getUserName());
	        
	        rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
        
        
        return rowUpdated;     
    }
	
public boolean InsertUser(UserProfile user) {
		
		String sql = "Insert into user_profile (user_name,user_password,user_fname, user_lname, user_mname,user_Address,user_Address2,user_City,user_State,user_Zipcode) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		boolean rowUpdated = false;
		try {
			con = getconnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1,user.getUserName());
			statement.setString(2,user.getPassword());
	        statement.setString(3, user.getFirstName());
	        statement.setString(4, user.getLastName());
	        statement.setString(5, user.getMiddleName());
	        statement.setString(6, user.getAddress());
	        statement.setString(7, user.getAddress1());
	        statement.setString(8, user.getCity());
	        statement.setString(9, user.getStateID());
	        statement.setString(10, user.getZipcode());
	        rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        disconnect(con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
        
        return rowUpdated;     
    }
		
	public boolean insertSkill(UserSkill Skill) throws SQLException {
        String sql = "INSERT INTO user_skills (user_name,skill) VALUES (?, ?)";
        Connection con = null;
        boolean rowInserted = false;
        
        try {
			con = getconnection();
			PreparedStatement statement = con.prepareStatement(sql);
		    statement.setString(1, Skill.getUserame());
		    statement.setString(2, Skill.getSkill());
		    rowInserted = statement.executeUpdate() > 0;
		    statement.close();
		    disconnect(con);
		    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}         
       
        return rowInserted;
    }
	
	public List<UserSkill> listSkills(String username) throws SQLException {
        List<UserSkill> skill = new ArrayList<>();
         
        String sql = "SELECT * FROM user_skills where user_name=?";
         
       Connection con=null;
       
       try {
    	   con = getconnection();
    	   PreparedStatement ps=con.prepareStatement(sql); 			  
   			ps.setString(1,username);  				              
   			ResultSet resultSet=ps.executeQuery();
   			
   			while (resultSet.next()) {
    		   String user = resultSet.getString("user_name");
    		   String userskill = resultSet.getString("skill");
    		   int skillid = resultSet.getInt("skill_id");       
    		   UserSkill st = new UserSkill(skillid,user,userskill);
    		   skill.add(st);
    	   	}
   			resultSet.close();
   			ps.close();
   			disconnect(con);
       } catch (ClassNotFoundException e) {
       			e.printStackTrace();
       		}
       catch (SQLException e) {
  			e.printStackTrace();
  		}  
         return skill;
    }
	
	 public boolean deleteSkill(int id) throws SQLException {
		 	String sql = "DELETE FROM user_skills where skill_id=?";
	        Connection con = null;
	        boolean rowDeleted = false;
	        
	        try {
				con = getconnection();
				PreparedStatement statement = con.prepareStatement(sql);
			    statement.setInt(1, id);
			    rowDeleted = statement.executeUpdate() > 0;
			    statement.close();
			    disconnect(con);
			    
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}         
	       
	        return rowDeleted;   
	    }
	 public boolean updateSkill(UserSkill Skill) throws SQLException {
		 	String sql = "update user_skills set skill=? where user_name=? and skill_id=?";
	        Connection con = null;
	        boolean rowUpdated = false;
	        
	        try {
				con = getconnection();
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, Skill.getSkill());
			    statement.setString(2, Skill.getUserame());
			    statement.setInt(3, Skill.getSkillID());
			    rowUpdated = statement.executeUpdate() > 0;
			    statement.close();
			    disconnect(con);
			    
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}         
	       
	        return rowUpdated;   
	    }
	 public UserSkill getUserSkill(int skillid) {
		 	UserSkill skill = null;
			try{  
				Connection con=getconnection();  			            
				PreparedStatement ps=con.prepareStatement(  
				    "select * from user_skills where skill_id=?"); 			  
				ps.setInt(1, skillid)	;			              
				ResultSet rs=ps.executeQuery();  
				if (rs.next()) {
					skill = new UserSkill();
					skill.setSkill(rs.getString("skill"));
					skill.setSkillID(rs.getInt("skill_id"));						}
				rs.close();
				disconnect(con);
			}catch(Exception e){
				 System.out.println(e.getMessage());
				 
			 }  
	        return skill;
	        
				  
		}
	 public Education getEducation(int id) {
		 Education st = null;
			try{  
				Connection con=getconnection();  			            
				PreparedStatement ps=con.prepareStatement(  
				    "select * from user_education where id=?"); 			  
				ps.setInt(1, id)	;			              
				ResultSet rs=ps.executeQuery();  
				if (rs.next()) {
					String Degree=rs.getString("school_degree");
	   				String gmonth=rs.getString("school_gradmonth");
	   				String gYear=rs.getString("school_gradyear");
	   				String slocation=rs.getString("school_location");
	   				String Major=rs.getString("school_Major");
	   				String sname=rs.getString("school_name");
	   				// id=rs.getInt("user_educationid");
	   				String uname=rs.getString("user_name");
	   				 st = new Education(id,uname, Degree, sname,slocation,gmonth, gYear,Major);
	    		   					}
				rs.close();
				disconnect(con);
			}catch(Exception e){
				 System.out.println(e.getMessage());
				 
			 }  
	        return st;
	        
				  
		}
	 
	 public boolean insertUserEducation(Education edu) throws SQLException {
	        String sql = "INSERT INTO user_education (user_name,school_name,school_major,school_location,school_gradyear,school_gradmonth,school_degree)"
	        		+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	        Connection con = null;
	        boolean rowInserted = false;
	        
	        try {
				con = getconnection();
				PreparedStatement statement = con.prepareStatement(sql);
			    statement.setString(1, edu.getUserame());
			    statement.setString(2, edu.getSchoolName());
			    statement.setString(3, edu.getMajor());
			    statement.setString(4,edu.getSchoolLocation());
			    statement.setString(5,edu.getGradYear());
			    statement.setString(6, edu.getGradMonth());
			    statement.setString(7, edu.getDegree());
			    rowInserted = statement.executeUpdate() > 0;
			    statement.close();
			    disconnect(con);
			    
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}         
	       
	        return rowInserted;
	    }
	 
	 public boolean updateUserEducation(Education edu) {
			
			String sql = "update user_education set  school_name=?,school_major=?,school_location=?,school_gradyear=?,school_gradmonth=?,school_degree=? where user_name=?";
			Connection con = null;
			boolean rowUpdated = false;
			try {
				con = getconnection();
				PreparedStatement statement = con.prepareStatement(sql);
			    statement.setString(7, edu.getUserame());
			    statement.setString(1, edu.getSchoolName());
			    statement.setString(2, edu.getMajor());
			    statement.setString(3,edu.getSchoolLocation());
			    statement.setString(4,edu.getGradYear());
			    statement.setString(5, edu.getGradMonth());
			    statement.setString(6, edu.getDegree());
		        
		        rowUpdated = statement.executeUpdate() > 0;
		        statement.close();
		        disconnect(con);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
	        
	        
	        return rowUpdated;     
	    }
	 public List<Education> listEducation(String username) throws SQLException {
	        List<Education> edu = new ArrayList<>();
	         
	        String sql = "SELECT * FROM user_education where user_name=?";
	         
	       Connection con=null;
	       
	       try {
	    	   con = getconnection();
	    	   PreparedStatement ps=con.prepareStatement(sql); 			  
	   			ps.setString(1,username);  				              
	   			ResultSet resultSet=ps.executeQuery();
	   			
	   			while (resultSet.next()) {
	   				String Degree=resultSet.getString("school_degree");
	   				String gmonth=resultSet.getString("school_gradmonth");
	   				String gYear=resultSet.getString("school_gradyear");
	   				String slocation=resultSet.getString("school_location");
	   				String Major=resultSet.getString("school_Major");
	   				String sname=resultSet.getString("school_name");
	   				int id=resultSet.getInt("user_educationid");
	   				String uname=resultSet.getString("user_name");
	   				Education st = new Education(id,uname, Degree, sname,slocation,gmonth, gYear,Major);
	    		   edu.add(st);
	    	   	}
	   			resultSet.close();
	   			ps.close();
	   			disconnect(con);
	       } catch (ClassNotFoundException e) {
	       			e.printStackTrace();
	       		}
	       catch (SQLException e) {
	  			e.printStackTrace();
	  		}  
	         return edu;
	    }
		
		 public boolean deleEdu(int id) throws SQLException {
			 	String sql = "DELETE FROM user_education where user_educationid=?";
		        Connection con = null;
		        boolean rowDeleted = false;
		        
		        try {
					con = getconnection();
					PreparedStatement statement = con.prepareStatement(sql);
				    statement.setInt(1, id);
				    rowDeleted = statement.executeUpdate() > 0;
				    statement.close();
				    disconnect(con);
				    
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}         
		       
		        return rowDeleted;   
		    }
		 
		 public boolean deleteWork(int id) throws SQLException {
			 	String sql = "DELETE FROM user_workhistory where user_workhistoryid=?";
		        Connection con = null;
		        boolean rowDeleted = false;
		        
		        try {
					con = getconnection();
					PreparedStatement statement = con.prepareStatement(sql);
				    statement.setInt(1, id);
				    rowDeleted = statement.executeUpdate() > 0;
				    statement.close();
				    disconnect(con);
				    
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}         
		       
		        return rowDeleted;   
		    }
		 public List<Workhistory> listWork(String username) throws SQLException {
		        List<Workhistory> work = new ArrayList<>();
		         
		        String sql = "SELECT * FROM user_workhistory where user_name=?";
		         
		       Connection con=null;
		       
		       try {
		    	   con = getconnection();
		    	   PreparedStatement ps=con.prepareStatement(sql); 			  
		   			ps.setString(1,username);  				              
		   			ResultSet resultSet=ps.executeQuery();
		   			
		   			while (resultSet.next()) {
		   				String JobTitle=resultSet.getString("job_title");
		   				String JobEmployer=resultSet.getString("job_employer");
		   				String JobCity=resultSet.getString("job_city");
		   				String JobState=resultSet.getString("job_state");
		   				Date stdate=resultSet.getDate("start_date");
		   				Date enddate=resultSet.getDate("end_date");
		   				int iscurrent=resultSet.getInt("is_currentemp");
		   				int id =resultSet.getInt("user_workhistoryid");
		   				Workhistory st = new Workhistory(id,username, JobTitle, JobEmployer, JobCity, JobState,  stdate, enddate, iscurrent);
		   				work.add(st);
		    	   	}
		   			resultSet.close();
		   			ps.close();
		   			disconnect(con);
		       } catch (ClassNotFoundException e) {
		       			e.printStackTrace();
		       		}
		       catch (SQLException e) {
		  			e.printStackTrace();
		  		}  
		         return work;
		    }
		 public boolean updateWorkhistory(Workhistory work) {
				
				String sql = "update user_workhistory set  job_title=?,job_employer=?,job_city=?,job_state=?,start_date=?,end_date=?,is_currentemp=? where user_name=?";
					
				Connection con = null;
				boolean rowUpdated = false;
				try {
					con = getconnection();
					PreparedStatement statement = con.prepareStatement(sql);
				    statement.setString(8, work.getUsername());
				    statement.setString(1, work.getJobTitle());
				    statement.setString(2, work.getJobEmployer());
				    statement.setString(3, work.getJobCity());
				    statement.setString(4,work.getJobState());
				    statement.setDate(5, work.getstdate());
				    statement.setDate(6,work.getenddate());
				    statement.setInt(7,work.getiscurrentemp());
			        rowUpdated = statement.executeUpdate() > 0;
			        statement.close();
			        disconnect(con);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
				
		        
		        
		        return rowUpdated;     
		    }
		 
	public Workhistory getWorkhistory(int id) {
			 Workhistory st = null;
				try{  
					Connection con=getconnection();  			            
					PreparedStatement ps=con.prepareStatement(  
					    "select * from user_workhistory where id=?"); 			  
					ps.setInt(1, id)	;			              
					ResultSet rs=ps.executeQuery();  
					if (rs.next()) {
						String JobTitle=rs.getString("school_degree");
		   				String JobEmployer=rs.getString("school_gradmonth");
		   				String JobCity=rs.getString("school_gradyear");
		   				String JobState=rs.getString("school_Major");
		   				Date stdate= rs.getDate("start_date");
		   				Date enddate= rs.getDate("end_date");
		   				int iscurrent= rs.getInt("is_currentemp");
		   				String uname=rs.getString("user_name");
		   				st = new Workhistory(id,uname, JobTitle, JobEmployer, JobCity, JobState,  stdate, enddate, iscurrent);
		   				rs.close();
		   				disconnect(con);
					}
				}catch(Exception e){
					 System.out.println(e.getMessage());
					 
				 }  
		        return st;
		        
					  
			}
		 
		 public boolean insertWorkhistory(Workhistory work) throws SQLException {
		        String sql = "INSERT INTO user_workhistory (user_name,job_title,job_employe,job_city,job_state,start_date,end_date,is_currentemp)"
		        		+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		        	        
		        Connection con = null;
		        boolean rowInserted = false;
		        
		        try {
					con = getconnection();
					PreparedStatement statement = con.prepareStatement(sql);
				    statement.setString(8, work.getUsername());
				    statement.setString(1, work.getJobTitle());
				    statement.setString(2, work.getJobEmployer());
				    statement.setString(3, work.getJobCity());
				    statement.setString(4,work.getJobState());
				    statement.setDate(5, work.getstdate());
				    statement.setDate(6,work.getenddate());
				    statement.setInt(7,work.getiscurrentemp());
				    rowInserted = statement.executeUpdate() > 0;
			        statement.close();
			        disconnect(con);
				    
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}         
		       
		        return rowInserted;
		    }
		 
		
}
