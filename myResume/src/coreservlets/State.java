package coreservlets;

public class State {
	private int State_ID;
	private String State_Name;
	private String State_Code;
	
	public State() {
		
	}
	
	public State(int StateID, String StateName,String StateCode) {
		this.State_ID=StateID;
		this.State_Name=StateName;	
		this.State_Code=StateCode;
	}
	public String getStateName() {
		return State_Name;
	}
	public void setStateName(String stname) {
		this.State_Name=stname;
	}
	public String getStateCode() {
		return State_Code;
	}
	public void setStateCode(String stcode) {
		this.State_Code=stcode;
	}
	public int getStateID() {
		return State_ID;
	}
	public void setStateID(int stid) {
		this.State_ID=stid;
	}
}

