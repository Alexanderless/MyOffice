package com.beifeng.biz.cc;

import java.util.List;

import com.beifeng.model.ManualSign;

public interface IManualSignBizcc {
	//����signId ����ǩ����Ϣ
	ManualSign queryManByUserId(Integer signId);
	//����ǩ������
	void insertManualSign(ManualSign manualSign);
}
