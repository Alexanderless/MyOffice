package com.beifeng.biz.hr.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beifeng.biz.hr.IDepartInfoBiz;
import com.beifeng.dao.hr.IDepartInfoDao;
import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;
@Service
public class IDeparInfoBizImpl implements IDepartInfoBiz{
	@Autowired
	private IDepartInfoDao iDepartInfoDao;

	@Override
	public List<DepartInfo> queryDepartInfo() {
		List<DepartInfo> list = iDepartInfoDao.queryDepartInfo();
		return list;
	}
	/*
	 * getJson(non-Javadoc)
	 * @see com.beifeng.biz.IDepartInfoBiz#queryDepartInfo()
	 */
	@Override
	public String getJson() {
		String json="[";
		List<DepartInfo> list = iDepartInfoDao.queryDepartInfo();
		for(int i = 0; i < list.size(); i++){
			DepartInfo departInfo=list.get(i);
			if(i==(list.size()-1)){
				json+="{name:\""+departInfo.getBranchInfo().getBranchName()+"\",open:"+true+",children:[{name:\""+departInfo.getDepartName()+"\",children:[{name:\""+departInfo.getUserInfo().getUserName()+"\"}]}";
			}else
			{
				json+="{name:\""+departInfo.getBranchInfo().getBranchName()+"\",open:"+true+",children:[{name:\""+departInfo.getDepartName()+"\",children:[{name:\""+departInfo.getUserInfo().getUserName()+"\"}]},";		
			}
		}
		return json+"]";
	}
	@Override
	public void delDepartInfo(Integer id) {
		iDepartInfoDao.delDepartInfo(id);
	}

	@Override
	public void addDepartInfo(DepartInfo departInfo) {
		iDepartInfoDao.addDepartInfo(departInfo);
		
	}
	
	/*
	 * 分页显示(non-Javadoc)
	 * @see com.beifeng.biz.IDepartInfoBiz#queryPageDepartInfo(com.beifeng.model.PageDepartInfo)
	 */
	@Override
	public PageDepartInfo queryPageDepartInfo(PageDepartInfo pageDepartInfo) {
		List<DepartInfo> pageList = iDepartInfoDao.queryPageDepartInfo(pageDepartInfo);
		PageDepartInfo pdepInfo = new PageDepartInfo();
		pdepInfo.setCurrentPage(pageDepartInfo.getCurrentPage());
		pdepInfo.setPageRecords(pageDepartInfo.getPageRecords());
		pdepInfo.setList(pageList);
		List<DepartInfo> list = iDepartInfoDao.queryDepartInfo();
		pdepInfo.setTotalRecords(list.size());
		return pdepInfo;
	}
	
	/*
	 * 根据branchId查询部门
	 */
	@Override
	public List<DepartInfo> queryDepartById(Integer branchId) {
		List<DepartInfo> list = iDepartInfoDao.queryDepartById(branchId);
		return list;
	}
	
	/*
	 *根据DepartInfo查询部门
	 */
	@Override
	public DepartInfo queryDepartInfoById(Integer id) {
		DepartInfo departInfo = iDepartInfoDao.queryDepartInfoById(id);
		return departInfo;
	}
}
