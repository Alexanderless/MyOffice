package com.beifeng.dao.cc;

import java.util.List;

import com.beifeng.model.ManualSign;

public interface IManualSignDaocc {
	//根据signId 查找签卡信息
	ManualSign queryManByUserId(Integer signId);
	//插入签卡数据
	void insertManualSign(ManualSign manualSign);
}
