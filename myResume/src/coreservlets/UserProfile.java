package coreservlets;

public class UserProfile {
	//private int userID;
	private String userName;
	private String fName;
	private String lName;
	private String mName;
	private String uPassword;
	private String uStateID;
	private String City;
	private String uZipcode;
	private String uAddress1;
	private String uAddress2;
	
	
	public UserProfile() {
		
	}
	 public UserProfile(String userName,String password,String fName, String lName, String mName, String Address, String Address2, String State, String City, String Zip) {
		 	//this.us=uid;
		 	this.userName = userName;
	        this.fName = fName;
	        this.lName = lName;
	        this.mName = mName;
	        this.uPassword=password;
	        this.uAddress1=Address;
	        this.uAddress2=Address2;
	        this.uStateID=State;
	        this.City=City;
	        this.uZipcode=Zip;    
	        this.uPassword=password;
	   }
	
	 //Password
	 public String getPassword() {
	        return uPassword;
	  }
	  public void setPassword(String password) {
	        this.uPassword = password;
	  }
	  //UserName
	 public String getUserName() {
	        return userName;
	  }
	  public void setUserName(String userName) {
	        this.userName = userName;
	  }
	  //FirstName
	  public String getFirstName() {
	        return fName;
	  }
	  public void setFirstName(String firstName) {
	        this.fName = firstName;
	  }
	  //LastName
	  public String getLastName() {
		  return lName;
	  }
	  public void setLastName(String lastName) {
		  this.lName = lastName;		  
	  }
	  //MiddleName
	  public void setMiddleName(String middleName) {
		  this.mName=middleName;
	  }
	  public String getMiddleName() {
		  return mName;
	  }
	  //Address
	  public void setAddress(String Address) {
		  this.uAddress1=Address;
	  }
	  public String getAddress() {
		  return uAddress1;
	  }
	  //Address1
	  public void setAddress1(String Address1) {
		  this.uAddress2=Address1;
	  }
	  public String getAddress1() {
		  return uAddress2;
	  }
	  
	  //CityID
	  public void setCity(String City) {
		  this.City=City;
	  }
	  public String getCity() {
		  return this.City;
	  }
	  
	  //StateID
	  public void setStateID(String StateID) {
		  this.uStateID=StateID;
	  }
	  public String getStateID() {
		  return uStateID;
	  }
	  
	  //Zipcode
	  public void setZipcode(String Zipcode) {
		  this.uZipcode=Zipcode;
	  }
	  public String getZipcode() {
		  return uZipcode;
	  }
	  
}

