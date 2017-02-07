package com.beifeng.dao.ns;

import java.util.List;

import com.beifeng.model.Message;
import com.beifeng.model.PageMessage;

public interface IMessageDao {
	//��ѯȫ��
	List<Message> queryMessage(PageMessage pageMessage);
	
	//��ҳ��ʾ
	List<Message> queryPageMessage(PageMessage pageMessage);
	
	//������ѯ��ʾ
	List<Message> querySeaMessage(PageMessage pageMessage);
	
	//ͨ��id��message
	Message queryMsgById(Integer id);
	
	//�޸�message
	void updataMsg(Message message);
	
	//ɾ��message
	void delMessage(Integer id);
	
	//�ռ��������
	List<Message> queryInboxCount(Integer id);
	
	//�ռ���δ��������
	List<Message> queryUnread(Integer id);
	
	//�ѷ���
	List<Message> send(Integer id);
	
	//����
	void ifPublish(Integer id);
	
	//��ɾ���ռ���
	void del(List list);
}