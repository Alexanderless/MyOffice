package com.beifeng.biz.cg;

import java.util.List;

import com.beifeng.model.DepartInfo;

public interface IDepartInfoBizcg {
	//��ѯ���в�����Ϣ
	List<DepartInfo> queryDepList(Integer branchId);
}
