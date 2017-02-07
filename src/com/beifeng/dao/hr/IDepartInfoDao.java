package com.beifeng.dao.hr;

import java.util.List;

import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;

public interface IDepartInfoDao {
	//��ʾȫ��
	List<DepartInfo> queryDepartInfo();
	
	//��ҳ��ʾ
	List<DepartInfo> queryPageDepartInfo(PageDepartInfo pageDepartInfo);
	//ɾ��
	void delDepartInfo(Integer id);
	//���
	void addDepartInfo(DepartInfo departInfo);
	
	//ͨ��branchId����ѯ 
	List<DepartInfo> queryDepartById(Integer branchId);
	
	//ͨ��DepartId����ѯ
	DepartInfo queryDepartInfoById(Integer id);
}
