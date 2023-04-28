package com.HV2023.entity;

public class account {
	private int uID;
	private String userName;
	private String passWord;
	private boolean isAdmin;
	public account(int uID, String userName, String passWord, boolean isAdmin) {
		super();
		this.uID = uID;
		this.userName = userName;
		this.passWord = passWord;
		this.isAdmin = isAdmin;
	}
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
