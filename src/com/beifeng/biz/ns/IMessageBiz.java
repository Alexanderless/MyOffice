package com.beifeng.biz.ns;

import java.util.List;

import com.beifeng.model.Email;
import com.beifeng.model.Message;
import com.beifeng.model.MessageAndUser;
import com.beifeng.model.PageMessage;

public interface IMessageBiz {
	//查询全部
	List<MessageAndUser> queryMessage(PageMessage pageMessage);
	
	//分页显示
	PageMessage queryPageMessage(PageMessage pageMessage);
	
	//检索查询显示
	PageMessage querySeaMessage(PageMessage pageMessage);
	
	//通过id查message
	Message queryMsgById(Integer id);
	
	//修改message
	void updataMsg(Message message);
	
	//删除message
	void delMessage(Integer id);
	
	//收件箱多少条
	List<Message> queryInboxCount(Integer id);
		
	//收件箱未读多少条
	List<Message> queryUnread(Integer id);
		
	//已发送
	List<Message> send(Integer id);
	
	//获取数据
	Email getEamil(Integer id);
	
	//获取所有信息
	List<MessageAndUser> getInbox(Integer id);
	
	//已发送信息
	List<MessageAndUser> getSend(Integer id);
	
	//发布
	void ifPublish(Integer id);
	
	//假删除收件箱
	void del(List list);
}
