package com.beifeng.biz.cg.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.cg.IBranchInfoBizcg;
import com.beifeng.dao.cg.IBranchInfoDaocg;
import com.beifeng.model.BranchInfo;
@Service
public class IBranchInfoBizImplcg implements IBranchInfoBizcg{
	
	@Autowired
	private IBranchInfoDaocg iBranchInfoDao;
	@Override
	public List<BranchInfo> queryBranch() {
		
		return iBranchInfoDao.queryBranch();
	}

}
