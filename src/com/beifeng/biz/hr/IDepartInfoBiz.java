package com.beifeng.biz.hr;

import java.util.List;

import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;

public interface IDepartInfoBiz {
	//查询全部
	List<DepartInfo> queryDepartInfo();
	
	//分页显示
	PageDepartInfo queryPageDepartInfo(PageDepartInfo pageDepartInfo);
		
	//删除
	void delDepartInfo(Integer id);
	
	//添加
	void addDepartInfo(DepartInfo departInfo);
	
	public String getJson();
	
	//通过branchId来查询 
	List<DepartInfo> queryDepartById(Integer branchId);
	
	//通过DepartId来查询
	DepartInfo queryDepartInfoById(Integer id);
}
