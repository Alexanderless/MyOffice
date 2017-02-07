package com.beifeng.model;

public class RoleInfo {
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private Integer ifDelete=0;	
	public Integer getIfDelete() {
		return ifDelete;
	}
	public void setIfDelete(Integer ifDelete) {
		this.ifDelete = ifDelete;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	@Override
	public String toString() {
		return "Roleinfo [roleId=" + roleId + ", roleName=" + roleName
				+ ", roleDesc=" + roleDesc + "]";
	}
	

}
