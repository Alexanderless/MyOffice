package com.beifeng.model;

import java.util.List;

public class BranchInfo {
	private Integer branchId;//字更ID
	private String branchName;//字更兆各
	private String branchShortName;//字更酒各
	private List<DepartInfo> list;
	
	public BranchInfo(){}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchShortName() {
		return branchShortName;
	}

	public void setBranchShortName(String branchShortName) {
		this.branchShortName = branchShortName;
	}
	
	public List<DepartInfo> getList() {
		return list;
	}

	public void setList(List<DepartInfo> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BranchInfo [branchId=" + branchId + ", branchName="
				+ branchName + ", branchShortName=" + branchShortName
				+  "]";
	}

	
	
	
}
