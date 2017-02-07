package com.beifeng.dao.hr;

import java.util.List;

import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;

public interface IDepartInfoDao {
	//显示全部
	List<DepartInfo> queryDepartInfo();
	
	//分页显示
	List<DepartInfo> queryPageDepartInfo(PageDepartInfo pageDepartInfo);
	//删除
	void delDepartInfo(Integer id);
	//添加
	void addDepartInfo(DepartInfo departInfo);
	
	//通过branchId来查询 
	List<DepartInfo> queryDepartById(Integer branchId);
	
	//通过DepartId来查询
	DepartInfo queryDepartInfoById(Integer id);
}
