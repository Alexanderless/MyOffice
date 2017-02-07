package com.beifeng.model;

import java.math.BigInteger;

public class DepartInfo {
	private Integer departId;
	private String departName;
	private UserInfo userInfo;
	private BigInteger connectTelNo;
	private BigInteger connectMobileTelNo;
	private BigInteger faxes;
	private BranchInfo branchInfo;
	public Integer getDepartId() {
		return departId;
	}
	public void setDepartId(Integer departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public BigInteger getConnectTelNo() {
		return connectTelNo;
	}
	public void setConnectTelNo(BigInteger connectTelNo) {
		this.connectTelNo = connectTelNo;
	}
	public BigInteger getConnectMobileTelNo() {
		return connectMobileTelNo;
	}
	public void setConnectMobileTelNo(BigInteger connectMobileTelNo) {
		this.connectMobileTelNo = connectMobileTelNo;
	}
	public BigInteger getFaxes() {
		return faxes;
	}
	public void setFaxes(BigInteger faxes) {
		this.faxes = faxes;
	}
	public BranchInfo getBranchInfo() {
		return branchInfo;
	}
	public void setBranchInfo(BranchInfo branchInfo) {
		this.branchInfo = branchInfo;
	}
	
	
	
	
}
