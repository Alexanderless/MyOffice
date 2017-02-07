package com.beifeng.biz.ns;

import java.util.List;

import com.beifeng.model.Email;
import com.beifeng.model.Message;
import com.beifeng.model.MessageAndUser;
import com.beifeng.model.PageMessage;

public interface IMessageBiz {
	//��ѯȫ��
	List<MessageAndUser> queryMessage(PageMessage pageMessage);
	
	//��ҳ��ʾ
	PageMessage queryPageMessage(PageMessage pageMessage);
	
	//������ѯ��ʾ
	PageMessage querySeaMessage(PageMessage pageMessage);
	
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
	
	//��ȡ����
	Email getEamil(Integer id);
	
	//��ȡ������Ϣ
	List<MessageAndUser> getInbox(Integer id);
	
	//�ѷ�����Ϣ
	List<MessageAndUser> getSend(Integer id);
	
	//����
	void ifPublish(Integer id);
	
	//��ɾ���ռ���
	void del(List list);
}
