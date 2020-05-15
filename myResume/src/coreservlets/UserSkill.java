package coreservlets;

public class UserSkill {
	protected int skillid;
	protected String username;
	protected String skill;
	
	public UserSkill() {
		
	}
	public UserSkill(int skillid,String username) {
		this.skillid=skillid;
		this.username=username;
	}
	public UserSkill(int skillid,String uname,String skill) {
		this.skillid=skillid;
		this.username=uname;
		this.skill=skill;
	}
	public int getSkillID() {  
	    return skillid;  
	}  
	  
	public void setSkillID(int skillid) {  
	    this.skillid = skillid;  
	}  
	
	public String getUserame() {  
	    return username;  
	}  
	  
	public void setUserName(String user) {  
	    this.username = user;  
	}  
	  
	public String getSkill() {  
	    return skill;  
	}  
	  
	public void setSkill(String skill) {  
	    this.skill = skill;  
	} 

}
