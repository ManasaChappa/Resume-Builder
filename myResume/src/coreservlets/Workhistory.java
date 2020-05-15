package coreservlets;

import java.sql.Date;

public class Workhistory {
	
	private String username;
	private String JobTitle;
	private String JobEmployer;
	private String JobCity;
	private String JobState;
	private Date stdate;
	private Date enddate;
	private int id;
	private int iscurrentemp;
	
	public Workhistory() {
		
	}
	public Workhistory(int id,String username) {
		this.id=id;
		this.username=username;
	}
	public Workhistory(int id,String uname,String JobTitle,String JobEmployer,String JobCity,String JobState, Date stdate,Date enddate,int iscurrent) {
		this.id=id;
		this.username=uname;
		this.JobTitle=JobTitle;
		this.JobEmployer=JobEmployer;
		this.JobCity=JobCity;
		this.JobState=JobState;
		this.stdate=stdate;
		this.enddate=enddate;
	}
	public int getiscurrentemp() {  
	    return this.iscurrentemp;  
	}  
	  
	public void setiscurrentemp(int iscurrentemp) {  
	    this.iscurrentemp = iscurrentemp;  
	}  
	public int getid() {  
	    return this.id;  
	}  
	  
	public void setid(int id) {  
	    this.id = id;  
	}
	public Date getenddate(){
		return this.enddate;
	}
	public void setenddate(Date enddate){
		this.enddate=enddate;
	}
	public Date getstdate(){
		return this.stdate;
	}
	public void setstdate(Date stdate){
		this.stdate=stdate;
	}
	public String getJobState(){
		return this.JobState;
	}
	public void setJobState(String JobState){
		this.JobState=JobState;
	}
	public String getJobCity(){
		return this.JobCity;
	}
	public void setJobCity(String JobCity){
		this.JobCity=JobCity;
	}
	public String getJobEmployer(){
		return this.JobEmployer;
	}
	public void setJobEmployer(String JobEmployer){
		this.JobEmployer=JobEmployer;
	}
	
	public String getJobTitle(){
		return this.JobTitle;
	}
	public void setJobTitle(String Jobtitle){
		this.JobTitle=Jobtitle;
	}
	
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
}

