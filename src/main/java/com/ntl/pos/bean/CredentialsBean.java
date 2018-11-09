package com.ntl.pos.bean;

public class CredentialsBean {

	String userId;
	String password;
	String usertype;
	int loginStatus;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	public CredentialsBean() {
		
	}
	public CredentialsBean(String userId, String password, String usertype, int loginStatus) {
		super();
		this.userId = userId;
		this.password = password;
		this.usertype = usertype;
		this.loginStatus = loginStatus;
	}
	public CredentialsBean(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
}
