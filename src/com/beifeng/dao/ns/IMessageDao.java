package com.beifeng.dao.ns;

import java.util.List;

import com.beifeng.model.Message;
import com.beifeng.model.PageMessage;

public interface IMessageDao {
	//查询全部
	List<Message> queryMessage(PageMessage pageMessage);
	
	//分页显示
	List<Message> queryPageMessage(PageMessage pageMessage);
	
	//检索查询显示
	List<Message> querySeaMessage(PageMessage pageMessage);
	
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
	
	//发布
	void ifPublish(Integer id);
	
	//假删除收件箱
	void del(List list);
}
