package com.beifeng.dao.ns;


import java.util.List;

import com.beifeng.model.MessageToUser;

public interface IMessageToUserDao {
	
	//��ѯ����
	MessageToUser queryMessageToUser(Integer id);
	
	//ɾ��
	void delMessagetouser(Integer id);
	
	//�޸��Ƿ��Ѷ�
	void updateIfread(Integer id);
}
