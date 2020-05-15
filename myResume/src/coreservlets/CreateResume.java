package coreservlets;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class CreateResume {
	//private static Statement stmt;
	static XWPFDocument document = new XWPFDocument();

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

  
	  String username = null;
	 
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					username = c.getValue();
					resume(username);
				}
			}
		}
	}
	 //getUserProfile
	 //listEducation
	 //listWork
	public void resume(String name) throws IOException {
		
		UserLoginDAO userLoginDao = new UserLoginDAO();
		System.out.println(userLoginDao.getUserProfile(name));
		try {
			System.out.println(userLoginDao.listEducation(name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(userLoginDao.listWork(name));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
					
		//Write the Document in file system
	      FileOutputStream out = new FileOutputStream(new File("Resume.docx"));
	        
	     // create Paragraph
	      XWPFParagraph paragraph = document.createParagraph();
	      XWPFRun run = paragraph.createRun();
	      UserProfile user = userLoginDao.getUserProfile(name);
	      List<Education> userEdu;
	      try {
			userEdu = userLoginDao.listEducation(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      run.setText("username:"+ user.getUserName());
	      run.setText("First Name:"+ user.getFirstName());
	      run.setText("Last Name:"+ user.getLastName());
	      
	      run.setText("School:"+userEdu['sname']);
			
	      
	      document.write(out);
	      out.close();
      System.out.println("createResume.docx written successfully");
	
	}
}

