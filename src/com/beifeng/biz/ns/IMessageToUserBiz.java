package com.beifeng.biz.ns;


import java.util.List;

import com.beifeng.model.MessageToUser;

public interface IMessageToUserBiz {
	//��ѯ����
	MessageToUser queryMessageToUser(Integer id);
	
	//ɾ��
	void delMessagetouser(Integer id);
	
	//�޸��Ƿ��Ѷ�
	void updateIfread(Integer id);
}
