package com.beifeng.dao.cg;

import java.util.List;

import com.beifeng.model.DepartInfo;

public interface IDepartInfoDaocg {
	//��ѯ������Ϣ
	List<DepartInfo> queryDepList(Integer branchId);
	
}
