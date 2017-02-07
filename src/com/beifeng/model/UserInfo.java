package com.beifeng.model;

public class UserInfo {
	private String userId;
	private String userName;
	private String passWord;
	private DepartInfo departInfo;
	private String gender;
	private RoleInfo roleInfo;
	private UserState userState;
	private String picPath;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public DepartInfo getDepartInfo() {
		return departInfo;
	}
	public void setDepartInfo(DepartInfo departInfo) {
		this.departInfo = departInfo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public RoleInfo getRoleInfo() {
		return roleInfo;
	}
	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public UserState getUserState() {
		return userState;
	}
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", passWord=" + passWord + ", departInfo=" + departInfo
				+ ", gender=" + gender + ", roleInfo=" + roleInfo
				+ ", userState=" + userState + ", picPath=" + picPath + "]";
	}
	
	
	
}
