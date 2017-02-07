package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.DepartInfo;

public interface IDepartInfoDaocg {
	//查询部门信息
	List<DepartInfo> queryDepList(Integer branchId);
	
}
