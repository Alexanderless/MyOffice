package com.beifeng.dao.cc;

import java.util.List;

import com.beifeng.model.ManualSign;

public interface IManualSignDaocc {
	//����signId ����ǩ����Ϣ
	ManualSign queryManByUserId(Integer signId);
	//����ǩ������
	void insertManualSign(ManualSign manualSign);
}
