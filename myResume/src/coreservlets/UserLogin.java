package coreservlets;

public class UserLogin{
	private String userName;
	private String passWord;
	
	public UserLogin(String uname,String pwd) {
		this.userName=uname;
		this.passWord=pwd;
	}
	
	public String getUserame() {  
	    return userName;  
	}  
	  
	public void setUserNAME(String user) {  
	    this.userName = user;  
	}  
	  
	public String getPass() {  
	    return passWord;  
	}  
	  
	public void setPass(String pass) {  
	    this.passWord = pass;  
	}  
}
