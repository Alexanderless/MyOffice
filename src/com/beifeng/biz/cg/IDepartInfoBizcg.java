package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.DepartInfo;

public interface IDepartInfoBizcg {
	//查询所有部门信息
	List<DepartInfo> queryDepList(Integer branchId);
}
