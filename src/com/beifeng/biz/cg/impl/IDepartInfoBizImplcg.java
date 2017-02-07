package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IDepartInfoBizcg;
import com.beifeng.dao.cg.IDepartInfoDaocg;
import com.beifeng.model.DepartInfo;
@Service
public class IDepartInfoBizImplcg implements IDepartInfoBizcg{
	
	@Autowired
	public IDepartInfoDaocg iDepartInfoDao;
	//查询所有部门信息
	@Override
	public List<DepartInfo> queryDepList(Integer branchId) {
		return iDepartInfoDao.queryDepList(branchId);
	}

}
