package coreservlets;

public class Education {
	
	private String Degree;
	private String SchoolName;
	private String SchoolLocation;
	private String Major;
	private String gradMonth;
	private String gradYear;
	private String username;
	private int id;
	
	public Education() {
		
	}
	public Education(int id,String username) {
		this.id=id;
		this.username=username;
	}
	public Education(int id,String uname,String Degree,String sname,String slocation,String gmonth, String gYear,String Major) {
		this.id=id;
		this.username=uname;
		this.Degree=Degree;
		this.SchoolName=sname;
		this.SchoolLocation=slocation;
		this.gradMonth=gmonth;
		this.gradYear=gYear;
		this.Major=Major;
	}
	public int getid() {  
	    return this.id;  
	}  
	  
	public void setid(int id) {  
	    this.id = id;  
	}  
	
	public String getUserame() {  
	    return username;  
	}  
	  
	public void setUserName(String user) {  
	    this.username = user;  
	}  
	  
	public String getDegree() {  
	    return this.Degree;  
	}  
	  
	public void setDegree(String Degree) {  
	    this.Degree = Degree;  
	} 
	
	public String getSchoolName() {  
	    return this.SchoolName;  
	}  
	  
	public void setSchoolName(String schoolname) {  
	    this.SchoolName = schoolname;  
	} 
	public String getMajor() {  
	    return this.Major;  
	}  
	  
	public void setMajor(String Major) {  
	    this.Major = Major;  
	} 
	public String getSchoolLocation() {  
	    return this.SchoolLocation;  
	}  
	  
	public void setSchoolLocation(String location) {  
	    this.SchoolLocation = location;  
	} 
	public String getGradMonth() {  
	    return this.gradMonth;  
	}  
	  
	public void setGradMonth(String gradmonth) {  
	    this.gradMonth = gradmonth;  
	} 
	public String getGradYear() {  
	    return this.gradYear;  
	}  
	  
	public void setGradYear(String gradyear) {  
	    this.gradYear = gradyear;  
	} 
}
