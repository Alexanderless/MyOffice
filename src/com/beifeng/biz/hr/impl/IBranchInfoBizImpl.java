package com.beifeng.biz.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.hr.IBranchInfoBiz;
import com.beifeng.dao.hr.IBranchInfoDao;
import com.beifeng.model.BranchInfo;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.Page;
import com.beifeng.model.PageBranchInfo;
@Service
public class IBranchInfoBizImpl implements IBranchInfoBiz{
	@Autowired
	private IBranchInfoDao iBranchInfoDao;
	
	@Override
	public List<BranchInfo> queryBranchInfo() {
		 List<BranchInfo> list = iBranchInfoDao.queryBranchInfo();
		return list;
	}

	@Override
	public PageBranchInfo queryPageBranchInfo(Page page) {
		List<BranchInfo> list = iBranchInfoDao.queryPageBranchInfo(page);
		PageBranchInfo pbInfo = new PageBranchInfo();
		//��װ��ǰҳ��
		pbInfo.setCurrentPage(page.getCurrentPage());
		pbInfo.setPageRecords(page.getPageRecords());
		//��װ��ѯ���ļ���
		pbInfo.setList(list);
		//��ѯ�����ܼ�¼��
		List<BranchInfo> listInfo = iBranchInfoDao.queryBranchInfo();
		pbInfo.setTotalRecords(listInfo.size());
		return pbInfo;
	}

	@Override
	public void delBranchInfo(Integer id) {
		iBranchInfoDao.delBranchInfo(id);	
	}

	@Override
	public void updateBranchInfo(BranchInfo branchInfo) {
		iBranchInfoDao.updateBranchInfo(branchInfo);
		
	}

	@Override
	public void addBranchInfo(BranchInfo branchInfo) {
		if(branchInfo.getBranchName()!=null&&branchInfo.getBranchShortName()!=null){
			iBranchInfoDao.addBranchInfo(branchInfo);
		}	
	}	
}