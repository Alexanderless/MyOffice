package com.beifeng.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class OperateLog {
	 private Integer operateId;
	 private String userId;
	 private String operateName;
	 private String objectId;
     private String operateDesc;
     @DateTimeFormat(pattern="yyyy-MM-dd")
     private Date operateTime;
	public Integer getOperateId() {
		return operateId;
	}
	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getOperateDesc() {
		return operateDesc;
	}
	public void setOperateDesc(String operateDesc) {
		this.operateDesc = operateDesc;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	@Override
	public String toString() {
		return "OperateLog [operateId=" + operateId + ", userId=" + userId
				+ ", operateName=" + operateName + ", objectId=" + objectId
				+ ", operateDesc=" + operateDesc + ", operateTime="
				+ operateTime + "]";
	}
     
     
}
