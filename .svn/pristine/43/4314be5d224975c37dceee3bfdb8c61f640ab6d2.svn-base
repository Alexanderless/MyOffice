package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ManualSign {
	private Integer signId;//签卡id  
	private UserInfo userInfo;//签卡人
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date signTime;//签卡时间
	private String signDesc;//签卡备注
	private Integer signTag;//1代表签到； 2代表签退
	private BranchInfo branchInfo;//机构
	private DepartInfo departInfo;//部门
	
	public ManualSign(){}
	
	
	public Integer getSignId() {
		return signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getSignDesc() {
		return signDesc;
	}

	public void setSignDesc(String signDesc) {
		this.signDesc = signDesc;
	}

	public Integer getSignTag() {
		return signTag;
	}

	public void setSignTag(Integer signTag) {
		this.signTag = signTag;
	}
		
	public BranchInfo getBranchInfo() {
		return branchInfo;
	}

	public void setBranchInfo(BranchInfo branchInfo) {
		this.branchInfo = branchInfo;
	}

	public DepartInfo getDepartInfo() {
		return departInfo;
	}

	public void setDepartInfo(DepartInfo departInfo) {
		this.departInfo = departInfo;
	}

	@Override
	public String toString() {
		return "ManualSign [signId=" + signId + ", userInfo=" + userInfo
				+ ", signTime=" + signTime + ", signDesc=" + signDesc
				+ ", signTag=" + signTag + ", branchInfo=" + branchInfo
				+ ", departInfo=" + departInfo + "]";
	}
	
}
