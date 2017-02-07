package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Loginlog {
	private Integer loginId;
	private UserInfo userInfo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date loginTime;
	private Integer ifSuccess;
	private String loginUserIp;
	private String loginDesc;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getIfSuccess() {
		return ifSuccess;
	}

	public void setIfSuccess(Integer ifSuccess) {
		this.ifSuccess = ifSuccess;
	}

	public String getLoginUserIp() {
		return loginUserIp;
	}

	public void setLoginUserIp(String loginUserIp) {
		this.loginUserIp = loginUserIp;
	}

	public String getLoginDesc() {
		return loginDesc;
	}

	public void setLoginDesc(String loginDesc) {
		this.loginDesc = loginDesc;
	}

	@Override
	public String toString() {
		return "Loginlog [loginId=" + loginId + ", userInfo=" + userInfo
				+ ", loginTime=" + loginTime + ", ifSuccess=" + ifSuccess
				+ ", loginUserIp=" + loginUserIp + ", loginDesc=" + loginDesc
				+ "]";
	}

}
