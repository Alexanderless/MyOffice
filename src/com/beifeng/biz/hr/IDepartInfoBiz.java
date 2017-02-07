package com.beifeng.biz.hr;

import java.util.List;

import com.beifeng.model.DepartInfo;
import com.beifeng.model.PageDepartInfo;

public interface IDepartInfoBiz {
	//��ѯȫ��
	List<DepartInfo> queryDepartInfo();
	
	//��ҳ��ʾ
	PageDepartInfo queryPageDepartInfo(PageDepartInfo pageDepartInfo);
		
	//ɾ��
	void delDepartInfo(Integer id);
	
	//���
	void addDepartInfo(DepartInfo departInfo);
	
	public String getJson();
	
	//ͨ��branchId����ѯ 
	List<DepartInfo> queryDepartById(Integer branchId);
	
	//ͨ��DepartId����ѯ
	DepartInfo queryDepartInfoById(Integer id);
}
